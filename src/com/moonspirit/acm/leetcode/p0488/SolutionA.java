package com.moonspirit.acm.leetcode.p0488;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionA {
    int min = 6, boardStatus;

    public int findMinStep(String board, String hand) {
        int bLen = board.length();
        char[] line = new char[(bLen << 1) - 1];

        for (int i = 0; i < bLen; i++) {
            line[i << 1] = board.charAt(i);
            boardStatus ^= 1 << (i << 1);
        }
        for (int i = 0; i < line.length; i++) {
            System.out.printf("%c ", line[i]);
        }
        System.out.printf("\n%d\n", line.length);
        char[] hands = hand.toCharArray();
        Arrays.sort(hands);
        dfs(line, hands, hand.length());
        return min == 6 ? -1 : min;
    }

    void dfs(char[] board, char[] hand, int remain) {
        if (boardStatus == 0) {
            int res = hand.length - remain;
            if (res < min)
                min = res;
            return;
        }
        if (remain == 0) return;
        char val = 0;
        for (int i = 0; i < board.length; i++) {
            if ((boardStatus & (1 << i)) == 0 || board[i] == val) continue;
            val = board[i];
            int next = sameNext(board, i);
            if (next != -1) {
                if (board[next - 1] == 0) {
                    for (int j = 0; j < hand.length; j++) {
                        if (hand[j] != 0 && hand[j] != val && (j == 0 || hand[j - 1] != hand[j])) {
                            int mirror = boardStatus;
                            char temp = hand[j];
                            board[next - 1] = temp;
                            hand[j] = 0;
                            boardStatus ^= 1 << (next - 1);
                            dfs(board, hand, remain - 1);
                            //back track
                            boardStatus = mirror;
                            hand[j] = temp;
                        }
                    }
                }
                int j = 0;
                while (j < hand.length && hand[j] != val)
                    j++;
                if (j < hand.length) {
                    int mirror = boardStatus;
                    hand[j] = 0;
                    boardStatus ^= 1 << i | 1 << next;
                    checkThree(board, i - 1, next + 1);
                    dfs(board, hand, remain - 1);
                    hand[j] = val;
                    boardStatus = mirror;
                }
            } else {
                int left = 0;
                while (left < hand.length && hand[left] != val)
                    left++;
                if (left < hand.length - 1) {
                    int right = hand.length - 1;
                    while (right > left && hand[right] != val)
                        right--;
                    if (left < right) {
                        int mirror = boardStatus;
                        hand[left] = hand[right] = 0;
                        boardStatus ^= 1 << i;
                        checkThree(board, i - 1, i + 1);
                        dfs(board, hand, remain - 2);
                        hand[left] = hand[right] = val;
                        boardStatus = mirror;
                    }
                }
            }
        }
    }

    int sameNext(char[] board, int i) {
        int val = board[i];
        while (++i < board.length)
            if ((boardStatus & 1 << i) != 0)
                return board[i] == val ? i : -1;
        return -1;
    }

    void checkThree(char[] board, int left, int right) {
        while (left >= 0 && (boardStatus & 1 << left) == 0)
            left--;
        while (right < board.length && (boardStatus & 1 << right) == 0)
            right++;
        if (left < 0 || right >= board.length || board[left] != board[right])
            return;
        char val = board[left];
        int l = left - 1, r = right + 1;
        boolean pop = false;
        while (l >= 0) {
            if ((boardStatus & 1 << l) != 0) {
                if (board[l] == val) {
                    pop = true;
                    boardStatus ^= 1 << l;
                }
                break;
            } else
                l--;
        }
        while (r < board.length) {
            if ((boardStatus & 1 << r) != 0) {
                if (board[r] == val) {
                    pop = true;
                    boardStatus ^= 1 << r;
                }
                break;
            } else
                r++;
        }
        if (pop) {
            boardStatus ^= 1 << left | 1 << right;
            checkThree(board, l, r);
        }
    }
}