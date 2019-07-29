package com.frozen.frozenleetcode.tree;

import com.frozen.frozenleetcode.tree.utils.TreeNode;

import java.util.List;

/**
 * @author: Frozen
 * @create: 2019-07-16 20:15
 * @description: 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 **/
public class DistanceK {
    public static void main(String[] args) {
        DistanceK distanceK =new DistanceK();
        TreeNode root = new TreeNode(1);
        TreeNode target = new TreeNode(1);
        System.out.println(distanceK.distanceK(root,target,1));
    }

    /**
     *
     * @param root
     * @param target
     * @param K
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        if(root==null||target==null){
            return null;
        }
        return null;
    }

    /**
     *
     * @param root
     * @param target
     * @param K
     * @param parentK
     */
    private void distanceK(TreeNode root, TreeNode target, int K ,int parentK){

    }
}
