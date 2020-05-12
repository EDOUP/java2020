package com.edoup.thread.practise.jianzhi.tree;


/**
 * <p>
 * 二叉树 前序、中序、后序 遍历 简洁代码
 * </p>
 *
 * @author edoup
 * @date 2020/5/12 23:35
 */
public class Tree {


    public static void main(String[] args) {
        TreeNode root = getTestTree(); // 初始化一个二叉树
        preorderTraversal(root); // 先序遍历
        System.out.println();
        inorderTraversal(root); // 中序遍历
        System.out.println();
        postorderTraversal(root); // 后序遍历
    }

    public static void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + ",");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public static void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + ",");
            inorderTraversal(node.right);
        }
    }

    public static void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.val + ",");
        }
    }

    /**
     * - - - - - - - - 0 - - - - - - - -
     * - - - - - - - / - \ - - - - - - -
     * - - - - - - / - - - \ - - - - - - -
     * - - - - -  1 - - - - 2 - - - - - - -
     * - - - - - / - \ - - / - \ - - - - - -
     * - - - - 3- - - 4 - 5 - - 6 - - - - - -
     * - - - / - \ - - - - - - - -\ - - - - - -
     * - - 7- - - 8- - - - - - - - -9 - - - - -
     *
     * @return
     */
    public static TreeNode getTestTree() {
        TreeNode[] nodes = new TreeNode[10];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new TreeNode(i);
        }
        nodes[0].left = nodes[1];
        nodes[0].right = (nodes[2]);
        nodes[1].left = nodes[3];
        nodes[1].right = (nodes[4]);
        nodes[2].left = nodes[5];
        nodes[2].right = (nodes[6]);
        nodes[3].left = nodes[7];
        nodes[3].right = (nodes[8]);
        nodes[6].right = (nodes[9]);
        return nodes[0];
    }
}
