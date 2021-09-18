package com.moonspirit.acm.leetcode.p0102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 广度优先搜索。O(n) O(n)
 * <p>
 * 时间复杂度：每个结点入队出队各一次，故时间复杂度为O(n)。
 * 空间复杂度：队列中元素不超过n个，故空间复杂度为O(n)。
 */
class SolutionA {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> ans = new ArrayList<>();
            int n = queue.size();
            while (n-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                ans.add(node.val);
            }
            res.add(ans);
        }
        return res;
    }
}
