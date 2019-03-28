package com.frozen.frozenleetcode.tree.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        ((LinkedList<BinaryTreeNode>) queue).push(node);
        // 分别记录当前行未打印个数 以及下一行需要打印的个数
        int nextLevel = 0, toBePrint = 1;
        while (!queue.isEmpty()) {
            BinaryTreeNode temp = queue.poll();
            System.out.print(temp.value + " ");
            if (temp.leftNode != null) {
                queue.add(temp.leftNode);
                nextLevel++;
            }

            if (temp.rightNode != null) {
                queue.add(temp.rightNode);
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
