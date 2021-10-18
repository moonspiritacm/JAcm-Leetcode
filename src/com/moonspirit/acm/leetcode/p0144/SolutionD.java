package com.moonspirit.acm.leetcode.p0144;

import java.util.ArrayList;
import java.util.List;

/**
 * Morris。O(n) O(1)
 * <p>
 * 利用树的大量空闲指针（叶子结点），实现开销空间的极限缩减。
 * <p>
 * 对于没有左子树的结点只到达一次，对于有左子树的结点到达两次，前序遍历/中序遍历。
 * <p>
 * 1.如果root.left==null，root向右移动（root=root.right）；
 * 2.如果root.left!=null，找到root左子树的最右结点，记为node：
 * 2.1 如果node.right==null，将其指向root（node.right=root），root向左移动（root=root.left）；
 * 2.2 如果node.right==root，将其指向null（node.right=null），root向右移动（root=root.right）。
 * <p>
 */
public class SolutionD {
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        while (root != null) {
            if (root.left != null) { // 左孩子不为空
                // 左子树最右结点
                TreeNode node = root.left;
                while (node.right != null && node.right != root) {
                    node = node.right;
                }

                if (node.right == null) { // 建立回环
                    res.add(root.val);
                    node.right = root;
                    root = root.left;
                } else { // 撤销回环
                    node.right = null;
                    root = root.right;
                }
            } else {  // 左孩子为空
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}
