package com.moonspirit.acm.leetcode.p0036;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 哈希表。O(1) O(1)
 * <p>
 * 对于n×n棋盘，时间复杂度O(n^2)，空间复杂度O(n^2)。
 * <p>
 * 对于哈希表和数组计数，二者渐进时间复杂度相同，但是实际用时数组优于哈希表。哈希表查询和修改的复杂度为均摊O(1)，定长数组则为严格O(1)。
 */
class SolutionB {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }

        List<Set<Integer>> row = new ArrayList<>();
        List<Set<Integer>> col = new ArrayList<>();
        List<Set<Integer>> sqr = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            row.add(new HashSet<>());
            col.add(new HashSet<>());
            sqr.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int k = board[i][j] - '1';
                    int x = i / 3 * 3 + j / 3;
                    if (row.get(i).contains(k) || col.get(j).contains(k) || sqr.get(x).contains(k)) {
                        return false;
                    }
                    row.get(i).add(k);
                    col.get(j).add(k);
                    sqr.get(x).add(k);
                }
            }
        }
        return true;
    }
}
