package com.moonspirit.acm.leetcode.p0700;

class SolutionA {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            root = root.left;
        } else {
            root = root.right;
        }
        return searchBST(root, val);
    }
}
