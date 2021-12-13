package com.moonspirit.acm.leetcode.p0794;

/**
 * 分类讨论。O(C) O(1)
 * <p>
 * ①由于X先后，O后手，两方轮流下子。O的数量不能超过X，不能少于X-1；
 * ②如果X获胜，X的数量比O的数量多一；
 * ③如果O获胜，O的数量等于X的数量；
 * ④两方不能同时获胜。
 */
class Solution {
    private boolean check(String[] board, char ch) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == ch && board[i].charAt(1) == ch && board[i].charAt(2) == ch) {
                return true;
            }
            if (board[0].charAt(i) == ch && board[1].charAt(i) == ch && board[2].charAt(i) == ch) {
                return true;
            }
        }
        if (board[0].charAt(0) == ch && board[1].charAt(1) == ch && board[2].charAt(2) == ch) {
            return true;
        }
        if (board[0].charAt(2) == ch && board[1].charAt(1) == ch && board[2].charAt(0) == ch) {
            return true;
        }
        return false;
    }

    public boolean validTicTacToe(String[] board) {
        if (board == null || board.length != 3) {
            throw new IllegalArgumentException("非法输入");
        }

        int n1 = 0;
        int n2 = 0;
        boolean f1 = false;
        boolean f2 = false;
        for (String str : board) {
            for (char ch : str.toCharArray()) {
                if (ch == 'X') {
                    n1++;
                } else if (ch == 'O') {
                    n2++;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == 'X' && board[i].charAt(1) == 'X' && board[i].charAt(2) == 'X') {
                f1 = true;
            }
            if (board[i].charAt(0) == 'O' && board[i].charAt(1) == 'O' && board[i].charAt(2) == 'O') {
                f2 = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X') {
                f1 = true;
            }
            if (board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O') {
                f2 = true;
            }
        }
        if (board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X') {
            f1 = true;
        }
        if (board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X') {
            f1 = true;
        }
        if (board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O') {
            f2 = true;
        }
        if (board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O') {
            f2 = true;
        }

        if (n1 < n2 || n1 > n2 + 1 || f1 && f2 || f1 && n2 != n1 - 1 || f2 && n2 != n1) {
            return false;
        }
        return true;
    }
}

class Solution {
    public boolean validTicTacToe(String[] board) {
        char[][] cs = new char[3][3];
        int x = 0, o = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') x++;
                else if (c == 'O') o++;
                cs[i][j] = c;
            }
        }
        boolean a = check(cs, 'X'), b = check(cs, 'O');
        if (o > x || x - o > 1) return false;
        if (a && x <= o) return false;
        if (b && o != x) return false;
        if (a && b) return false;
        return true;
    }

    boolean check(char[][] cs, char c) {
        for (int i = 0; i < 3; i++) {
            if (cs[i][0] == c && cs[i][1] == c && cs[i][2] == c) return true;
            if (cs[0][i] == c && cs[1][i] == c && cs[2][i] == c) return true;
        }
        boolean a = true, b = true;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == j) a &= cs[i][j] == c;
                if (i + j == 2) b &= cs[i][j] == c;
            }
        }
        return a || b;
    }
}

作者：AC_OIer
        链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state/solution/gong-shui-san-xie-fen-qing-kuang-tao-lun-pikn/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
