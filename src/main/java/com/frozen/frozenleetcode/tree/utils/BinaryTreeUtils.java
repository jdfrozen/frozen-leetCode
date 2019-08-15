package com.frozen.frozenleetcode.tree.utils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: Frozen
 * @create: 2019-03-28 10:02
 * @description: 二叉树的工具类
 **/
public class BinaryTreeUtils {
    /**
     * 生成一个二叉树
     *
     * @return
     */
    public static TreeNode initBinaryTree() {
        TreeNode root = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode11 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode22 = new TreeNode(22);
        TreeNode treeNode222 = new TreeNode(22);
        root.left = treeNode1;
        root.right= treeNode11;
        treeNode1.left= treeNode2;
        treeNode11.left= treeNode22;
        treeNode11.right= treeNode222;
        return root;
    }

    /**
     * 打印二叉树
     * @param node
     */
    public static void showBinaryTree(TreeNode node){
        if(node==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        ((LinkedList<TreeNode>) queue).push(node);
        // 分别记录当前行未打印个数 以及下一行需要打印的个数
        int nextLevel = 0, toBePrint = 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + " ");
            if (temp.left != null) {
                queue.add(temp.left);
                nextLevel++;
            }

            if (temp.right != null) {
                queue.add(temp.right);
                nextLevel++;
            }
            toBePrint--;
            if (toBePrint == 0) {
                // 当前行打印完毕
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }
        }
    }

}
