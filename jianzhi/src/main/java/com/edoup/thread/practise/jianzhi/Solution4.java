package com.edoup.thread.practise.jianzhi;

/**
 * <p>
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和
 * 中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * </p>
 *
 * @author edoup
 * @date 2020/5/12 22:20
 */
public class Solution4 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        System.out.println(s.reConstructBinaryTree(pre, in));
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = new TreeNode(pre[0]);
        return treeNode;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
