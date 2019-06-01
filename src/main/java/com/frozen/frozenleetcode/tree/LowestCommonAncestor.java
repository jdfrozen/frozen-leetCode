package com.frozen.frozenleetcode.tree;

import java.util.LinkedList;
import java.util.List;

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
        TreeNode pppp = ancestor.lowestCommonAncestor(pParent0, pParent3, pParent4);
        System.out.println(pppp.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        LinkTreeNode pParent=null;
        LinkTreeNode qParent=null;
        LinkTreeNode parent=new LinkTreeNode(root);
        LinkTreeNode rootParent = parent;



        findNodeParent(rootParent,parent,pParent, qParent, root, p, q);
        while (true) {
            TreeNode pp = pParent.node;
            TreeNode qp = qParent.node;
            if (pp.equals(qp)) {
                return pp;
            } else {
                pParent = pParent.next;
                qParent = qParent.next;
            }
        }
    }

    private void findNodeParent(LinkTreeNode root,LinkTreeNode parent,LinkTreeNode pParent, LinkTreeNode qParent, TreeNode node, TreeNode p, TreeNode q) {
        if(parent!=null&&pParent!=null){
            return;
        }
        if (node.equals(p)) {
            pParent = copyParent( root);
        }
        if ( node.equals(q)) {
            qParent = copyParent( root);
        }
        TreeNode left = node.left;
        if (left != null) {
            parent.next = new LinkTreeNode(left);
            findNodeParent(root,parent.next,pParent, qParent, left, p, q);
        }
        TreeNode right = node.right;
        if (right != null) {
            parent.next = new LinkTreeNode(right);
            findNodeParent(root,parent.next,pParent, qParent, right, p, q);
        }

    }
    private LinkTreeNode copyParent(LinkTreeNode root){
        LinkTreeNode rootTemp = root;
        LinkTreeNode temp = new LinkTreeNode(rootTemp.node);
        LinkTreeNode linkTreeNode = temp;
        while (rootTemp.next!=null) {
            rootTemp = rootTemp.next;
            temp.next = new LinkTreeNode(rootTemp.node);
            temp = temp.next;
        }
        return linkTreeNode;
    }

    static class LinkTreeNode {
        TreeNode node;
        LinkTreeNode next;

        LinkTreeNode(TreeNode node) {
            this.node = node;
        }
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
