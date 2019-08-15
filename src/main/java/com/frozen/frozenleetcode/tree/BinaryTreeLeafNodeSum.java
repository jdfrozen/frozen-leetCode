package com.frozen.frozenleetcode.tree;

import com.frozen.frozenleetcode.tree.utils.TreeNode;
import com.frozen.frozenleetcode.tree.utils.BinaryTreeUtils;

/**
 * @author: Frozen
 * @create: 2019-03-28 09:39
 * @description: 二叉树的叶子节点求和
 * Find the sum of all left leaves in a given binary tree.
 **/
public class BinaryTreeLeafNodeSum {

    public static void main(String[] args) {
        BinaryTreeLeafNodeSum binaryTreeLeafBinaryTreeNodeSum = new BinaryTreeLeafNodeSum();
        TreeNode root = BinaryTreeUtils.initBinaryTree();
        BinaryTreeUtils.showBinaryTree(root);
        int sum = binaryTreeLeafBinaryTreeNodeSum.getBinaryTreeLeafNodeSum(root, false);
        System.out.println("sum=" + sum);
    }

    /**
     * 二叉树的叶子节点求和,递归
     *
     * @param TreeNode
     * @param isLeft
     * @return
     */
    public int getBinaryTreeLeafNodeSum(TreeNode TreeNode, boolean isLeft) {
        int sum = 0;
        if (TreeNode == null) {
            throw new RuntimeException("getBinaryTreeLeafBinaryTreeNodeSum root is null");
        }
        //只有是左叶子节点才求和
        if (TreeNode.left == null && TreeNode.right == null && isLeft) {
            return TreeNode.val;
        }
        if (TreeNode.left != null) {
            sum = sum + getBinaryTreeLeafNodeSum(TreeNode.left, true);
        }
        if (TreeNode.right != null) {
            sum = sum + getBinaryTreeLeafNodeSum(TreeNode.right, false);
        }
        return sum;
    }


}
