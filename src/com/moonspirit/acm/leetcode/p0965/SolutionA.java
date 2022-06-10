package com.moonspirit.acm.leetcode.p0965;

/**
 * 深度优先搜索（递归）。O(n) O(logn)
 */
class SolutionA {
    private boolean dfs(TreeNode root, int val) {
        if (root == null) {
            return true;
        }

        return root.val == val && dfs(root.left, val) && dfs(root.right, val);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("非法输入");
        }

        return dfs(root, root.val);
    }
}
