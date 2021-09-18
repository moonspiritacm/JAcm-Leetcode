package com.moonspirit.acm.leetcode.p0102;

import java.util.ArrayList;
import java.util.List;

/**
 * 深度优先搜有。O
 */
class Solution {
    private List<List<Integer>> res;

    private void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }

        if (res.size() <= level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        res = new ArrayList<>();
        dfs(root, 0);
        return res;
    }
}
