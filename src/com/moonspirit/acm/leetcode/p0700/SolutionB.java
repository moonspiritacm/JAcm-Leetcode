package com.moonspirit.acm.leetcode.p0700;

class SolutionB {
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null) {
            if(root.val>val) {
                root=root.left;
            } else if(root.val<val) {
                root=root.right;
            } else {
                return root;
            }
        }
        return null;
    }
}
