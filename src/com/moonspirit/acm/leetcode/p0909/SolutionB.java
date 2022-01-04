package com.moonspirit.acm.leetcode.p0909;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class SolutionB {
    public int snakesAndLadders(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0 || board.length != board[0].length) {
            throw new IllegalArgumentException("非法输入");
        }

        int n = board.length;
        int[] graph = new int[n * n + 1];
        for (int i = n - 1, k = 1; i >= 0; i--) {
            if (i % 2 != n % 2) {
                for (int j = 0; j < n; j++) {
                    graph[k++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    graph[k++] = board[i][j];
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        queue.offer(1);
        map.put(1, 0);
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            int res = map.get(pos);
            if (pos == n * n) {
                return res;
            }
            for (int k = pos + 1; k <= pos + 6 && k <= n * n; k++) {
                int next = graph[k] == -1 ? graph[k] : k;
                if (map.containsKey(next)) {
                    continue;
                }
                map.put(next, res + 1);
                queue.offer(next);
            }
        }
        return -1;
    }
}
