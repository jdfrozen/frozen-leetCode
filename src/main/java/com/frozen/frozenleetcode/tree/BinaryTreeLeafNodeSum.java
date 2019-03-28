package com.frozen.frozenleetcode.tree;

import com.frozen.frozenleetcode.tree.utils.BinaryTreeNode;
import com.frozen.frozenleetcode.tree.utils.BinaryTreeUtils;

/**
 * @author: Frozen
 * @create: 2019-03-28 09:39
 * @description: 二叉树的叶子节点求和
 **/
public class BinaryTreeLeafNodeSum {

    public static void main(String[] args) {
        BinaryTreeLeafNodeSum binaryTreeLeafBinaryTreeNodeSum = new BinaryTreeLeafNodeSum();
        BinaryTreeNode root = binaryTreeLeafBinaryTreeNodeSum.initBinaryTree();
        BinaryTreeUtils.showBinaryTree(root);
        int sum = binaryTreeLeafBinaryTreeNodeSum.getBinaryTreeLeafNodeSum(root);
        System.out.println("sum="+sum);
    }

    /**
     * 二叉树的叶子节点求和,递归
     *
     * @param BinaryTreeNode
     * @return
     */
    public int getBinaryTreeLeafNodeSum(BinaryTreeNode BinaryTreeNode) {
        int sum = 0;
        if (BinaryTreeNode == null) {
            throw new RuntimeException("getBinaryTreeLeafBinaryTreeNodeSum root is null");
        }
        if (BinaryTreeNode.leftNode == null && BinaryTreeNode.rightNode == null) {
            return BinaryTreeNode.value;
        }
        if (BinaryTreeNode.leftNode != null) {
            sum = sum + getBinaryTreeLeafNodeSum(BinaryTreeNode.leftNode);
        }
        if (BinaryTreeNode.rightNode != null) {
            sum = sum + getBinaryTreeLeafNodeSum(BinaryTreeNode.rightNode);
        }
        return sum;
    }

    /**
     * 生成一个二叉树
     *
     * @return
     */
    public BinaryTreeNode initBinaryTree() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode1 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode11 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode2 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode22 = new BinaryTreeNode(1);
        BinaryTreeNode binaryTreeNode222 = new BinaryTreeNode(1);
        root.leftNode =binaryTreeNode1;
        root.rightNode=binaryTreeNode11;
        return root;
    }

   
}
