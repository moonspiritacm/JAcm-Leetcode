package com.moonspirit.acm.leetcode.p0563;

/**
 * 深度优先搜索。O(n) O(n)
 * <p>
 * 在一趟遍历内，同时计算节点的坡度和权值和：直接使用节点坡度更新全局变量；返回节点权值和，用于父节点坡度和权值和计算。
 */
class Solution {
    private int res = 0;

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        res += Math.abs(left - right);
        return left + right + root.val;
    }

    public int findTilt(TreeNode root) {
        dfs(root);
        return res;
    }
}
