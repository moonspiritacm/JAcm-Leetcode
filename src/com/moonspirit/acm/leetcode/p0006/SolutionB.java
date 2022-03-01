package com.moonspirit.acm.leetcode.p0006;

/**
 * 模拟填入。O(m+n) O(m*n)
 */
class SolutionB {
    static int N = 1010;
    static int[] ids = new int[N];
    static char[][] graph = new char[N][N];

    public String convert(String s, int numRows) {
        if (s == null || s.length() == 0 || numRows <= 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (s.length() <= numRows || numRows == 1) {
            return s;
        }

        int n = s.length();
        int m = numRows;
        for (int i = 0; i < m; i++) {
            ids[i] = 0;
        }
        for (int i = 0, j = 0, k = -1; i < n; i++) {
            graph[j][ids[j]++] = s.charAt(i);
            if (j == 0 || j == m - 1) {
                k = -k;
            }
            j += k;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < ids[i]; j++) {
                sb.append(graph[i][j]);
            }
        }
        return sb.toString();
    }
}
