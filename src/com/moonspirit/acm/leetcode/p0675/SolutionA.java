package com.moonspirit.acm.leetcode.p0675;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 排序+宽度优先搜索。O((mn)^2) O(mn)
 *
 * ①只能按照从低到高的顺序砍树，没有高度相等的树。排序预处理即可得到唯一确定的砍树顺序。
 * ②树被砍成平地，仍然可以通过，图的连通性不变。两点间的最短路径，不因砍树发生改变。
 * 首先通过排序确定砍树顺序，然后依次计算两相邻点的最短路径，最后求得最短路径和。
 *
 * 预处理：最多有mn个树点，时间复杂度O(mn)，空间复杂度O(mn)
 * 排序：最多有mn个树点，时间复杂度O(mnlogmn)，空间复杂度O(logmn)
 * BFS求最短路（单次）：
 */
class SolutionA {
    int m = 0;
    int n = 0;
    int[][] graph;
    List<int[]> nodes;
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int bfs(int i, int j, int ii, int jj) {
        if (i == ii && j == jj) {
            return 0;
        }

        int res = 0;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        vis[i][j] = true;
        while (!queue.isEmpty()) {
            res++;
            int s = queue.size();
            while (s-- > 0) {
                int[] node = queue.poll();
                for (int k = 0; k < 4; k++) {
                    int x = node[0] + dirs[k][0];
                    int y = node[1] + dirs[k][1];
                    if (x < 0 || x >= m || y < 0 || y >= n || graph[x][y] == 0 || vis[x][y]) {
                        continue;
                    } else if (x == ii && y == jj) {
                        return res;
                    } else {
                        queue.offer(new int[]{x, y});
                        vis[x][y] = true;
                    }
                }
            }
        }
        return -1;
    }

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0 || forest.get(0).size() == 0) {
            throw new IllegalArgumentException("非法输入");
        }
        if (forest.get(0).get(0) == 0) {
            return -1;
        }

        m = forest.size();
        n = forest.get(0).size();
        graph = new int[m][n];
        nodes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = forest.get(i).get(j);
                if (graph[i][j] > 1) {
                    nodes.add(new int[]{graph[i][j], i, j});
                }
            }
        }
        Collections.sort(nodes, (a, b) -> a[0] - b[0]);

        int i = 0;
        int j = 0;
        int res = 0;
        for (int[] node : nodes) {
            int ii = node[1];
            int jj = node[2];
            int dist = bfs(i, j, ii, jj);
            if (dist == -1) {
                return -1;
            }
            res += dist;
            i = ii;
            j = jj;
        }
        return res;
    }
}
