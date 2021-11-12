package com.moonspirit.acm.leetcode.p0488;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    private String update(String board) {
        int i = 0;
        while (i < board.length()) {
            int j = i + 1;
            while (j < board.length() && board.charAt(i) == board.charAt(j)) {
                j++;
            }
            if (j - i >= 3) {
                board = board.substring(0, i) + board.substring(j);
                i = 0;
            } else {
                i = j;
            }
        }
        return board;
    }

    int m = 0;
    int n = 0;

    private int dfs(String board, String hand, boolean[] flag) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (!flag[i]) {
                for (int j = 0; j <= n; j++) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(board.substring(0,j))
                }
            }
        }

    }

    public int findMinStep(String board, String hand) {
        if (board == null || board.length() == 0 || hand == null || hand.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        Map<Character, Integer> dict = new HashMap<>();
        for (char ch : hand.toCharArray()) {
            dict.put(ch, dict.getOrDefault(ch, 0) + 1);
        }
        int res = dfs(board, dict);
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
