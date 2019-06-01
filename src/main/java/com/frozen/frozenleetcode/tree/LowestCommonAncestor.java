package com.frozen.frozenleetcode.tree;

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

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }

        return null;
    }

    private List<TreeNode> findNodeParent(List<TreeNode> nodeParent, TreeNode node, TreeNode p) {
        if (node.equals(p)) {
            return nodeParent;
        }
        nodeParent.add(node);
        TreeNode left = node.left;
        if (left != null) {
            findNodeParent(nodeParent, left, p);
        }
        TreeNode right = node.right;
        if (right != null) {
            findNodeParent(nodeParent, left, p);
        }
        return null;
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
