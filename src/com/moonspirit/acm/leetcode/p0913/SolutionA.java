package com.moonspirit.acm.leetcode.p0913;

/**
 * 动态规划。O(n^4) O(n^3)
 */
public class SolutionA {
    int bound = 0;  // 15、2n、2n^2
    static int N = 51;
    static int[][][] dp = new int[2 * N][N][N];

    private int dfs(int[][] graph, int k, int i, int j) {
        if (i == 0) {  // 老鼠到达洞口，老鼠胜利
            dp[k][i][j] = 1;
        } else if (i == j) {  // 猫和老鼠到达同一位置，猫胜利
            dp[k][i][j] = 2;
        } else if (k >= bound) {  // 到达最大步数，达成平局
            dp[k][i][j] = 0;
        } else if (dp[k][i][j] == -1) {
            if (k % 2 == 0) {  // 老鼠行动
                boolean win = false;  // 成功
                boolean draw = false;  // 平局

                // 遍历从节点i出发，下一步可达位置
                for (int next : graph[i]) {
                    int res = dfs(graph, k + 1, next, j);
                    if (res == 1) {  // 发现获胜节点，立即跳出循环
                        win = true;
                        break;
                    } else if (res == 0) {  // 发现平局节点，暂时保存，继续遍历
                        draw = true;
                    }
                }

                // 输出结果
                if (win) {
                    dp[k][i][j] = 1;
                } else if (draw) {
                    dp[k][i][j] = 0;
                } else {
                    dp[k][i][j] = 2;
                }
            } else {  // 猫行动
                boolean win = false;  // 成功
                boolean draw = false;  // 平局

                // 遍历从节点j出发，下一步可达位置
                for (int next : graph[j]) {
                    if (next == 0) {  // 猫不能到达节点0
                        continue;
                    }
                    int res = dfs(graph, k + 1, i, next);
                    if (res == 2) {  // 发现获胜节点，立即跳出循环
                        win = true;
                        break;
                    } else if (res == 0) {  // 发现平局节点，暂时保存，继续遍历
                        draw = true;
                    }
                }

                // 输出结果
                if (win) {
                    dp[k][i][j] = 2;
                } else if (draw) {
                    dp[k][i][j] = 0;
                } else {
                    dp[k][i][j] = 1;
                }
            }
        }
        return dp[k][i][j];
    }

    public int catMouseGame(int[][] graph) {
        if (graph == null || graph.length < 3 || graph[0].length == 0) {
            throw new IllegalArgumentException("非法输入");
        }

        bound = 2 * graph.length;
        // 初始化为-1（无效）
        for (int k = 0; k < bound; k++) {
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph.length; j++) {
                    dp[k][i][j] = -1;
                }
            }
        }
        return dfs(graph, 0, 1, 2);  // 起始位置：步数0，老鼠1，猫2
    }
}
