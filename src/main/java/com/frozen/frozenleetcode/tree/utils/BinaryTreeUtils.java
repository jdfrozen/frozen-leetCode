package com.frozen.frozenleetcode.tree.utils;

/**
 * @author: Frozen
 * @create: 2019-03-28 10:02
 * @description: 二叉树的工具类
 **/
public class BinaryTreeUtils {
    /**
     * 打印二叉树
     * @param node
     */
    public static void showBinaryTree(BinaryTreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.value);
        if(node.leftNode!=null){
            showBinaryTree(node.leftNode);
        }
        if(node.rightNode!=null){
            showBinaryTree(node.rightNode);
        }
    }

}
