package com.moonspirit.acm.leetcode.p0127;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private boolean isConnected(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int cnt = 0;
        for (int i = 0; i < s1.length() && cnt <= 1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt <= 1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || beginWord.length() != endWord.length() || wordList.size() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int n = wordList.size();
        boolean[][] graph = new boolean[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                graph[i][j] = graph[j][i] = isConnected(wordList.get(i), wordList.get(j));
            }
        }
        for (int i = 0; i < n; i++) {
            graph[i][n] = graph[n][i] = isConnected(wordList.get(i), beginWord);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (i == n - 1) {
                return
            }
            for (int j = 0; j <= n; j++) {
                if (graph[i][j]) {
                    graph[i][j] = graph[j][i] = false;
                    queue.offer(j);
                }
            }
        }
    }
}
