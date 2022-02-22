package com.moonspirit.acm.leetcode.p0838;

import java.util.LinkedList;
import java.util.Queue;

class SolutionA {
    public String pushDominoes(String dominoes) {
        if (dominoes == null || dominoes.length() == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        int n = dominoes.length();
        int[] is = new int[n];
        char[] cs = dominoes.toCharArray();
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] != '.') {
                int dire = cs[i] == 'L' ? -1 : 1;
                queue.offer(new int[]{i, 1, dire});
                is[i] = 1;
            }
        }
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int time = node[1];
            int dire = node[2];
            int next = node[0] + dire;
            if (next < 0 || next >= n || cs[node[0]] == '.') {  // 不再继续传导
                continue;
            }
            if (is[next] == 0) {
                queue.offer(new int[]{next, time + 1, dire});
                is[next] = time + 1;
                cs[next] = dire == -1 ? 'L' : 'R';
            } else if (is[next] == time + 1) {
                cs[next] = '.';
            }
        }
        return new String(cs);
    }
}
