package com.frozen.frozenleetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author: Frozen
 * @create: 2019-05-29 20:31
 * @description: 236. Lowest Common Ancestor of a Binary Tree
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 **/
public class LowestCommonAncestor {
    static  LinkedList<TreeNode> pParent ;
   static LinkedList<TreeNode> qParent;

    public static void main(String[] args) {
        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        TreeNode pParent0 = new TreeNode(0);
        TreeNode pParent1 = new TreeNode(1);
        TreeNode pParent2 = new TreeNode(2);
        TreeNode pParent3 = new TreeNode(3);
        TreeNode pParent4 = new TreeNode(4);
        TreeNode pParent5 = new TreeNode(5);
        TreeNode pParent6 = new TreeNode(6);
        /**
         *        0
         *     1     2
         *    3 4   5  6
         */
        pParent0.left = pParent1;
        pParent0.right = pParent2;
        pParent1.left = pParent3;
        pParent1.right = pParent4;
        pParent2.left = pParent5;
        pParent2.right = pParent6;
        TreeNode pppp = ancestor.lowestCommonAncestor(pParent0, pParent2, pParent3);
        System.out.println(pppp.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        LinkedList<TreeNode> parent = new LinkedList();
        parent.add(root);
        findNodeParent(parent, root, p, q);
        TreeNode result=root;
        while (true) {
            TreeNode pp = pParent.poll();
            TreeNode qp = qParent.poll();
            if(pp==null||qp==null){
                break;
            }
            if (!pp.equals(qp)) {
                break;
            }
            result = pp;
        }
        return result;
    }

    private void findNodeParent(LinkedList<TreeNode> parent, TreeNode node, TreeNode p, TreeNode q) {
        if(pParent!=null&&qParent!=null){
            return;
        }
        if (node.equals(p)) {
            pParent = copyParent(parent);
        }
        if (node.equals(q)) {
            qParent = copyParent(parent);
        }
        TreeNode left = node.left;
        if (left != null) {
            parent.add(left);
            findNodeParent(parent, left, p, q);
            parent.pollLast();
        }
        TreeNode right = node.right;
        if (right != null) {
            parent.add(right);
            findNodeParent(parent, right, p, q);
            parent.pollLast();
        }
    }


    private LinkedList<TreeNode> copyParent(LinkedList<TreeNode> parent) {
        LinkedList<TreeNode> linkTreeNode = new LinkedList();
        for(TreeNode treeNode:parent){
            linkTreeNode.add(treeNode);
        }
        return linkTreeNode;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
}
