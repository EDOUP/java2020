package leetcode.editor.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 104. 二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 * </p>
 *
 * @author edoup
 * @date 2020/12/23 1:56
 */
public class Code104 {


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(0);
        TreeNode left = new TreeNode(2);
        treeNode.left = left;
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode right = treeNode1;
        treeNode.right = right;
        TreeNode left1 = new TreeNode(1);
        left.left = left1;
        left1.left = new TreeNode(5);
        left1.right = new TreeNode(1);
        TreeNode left2 = new TreeNode(3);
        right.left = left2;
        left2.right = new TreeNode(6);
        TreeNode right1 = new TreeNode(-1);
        treeNode1.right = right1;
        right1.right = new TreeNode(8);
        Code104 code104 = new Code104();
        System.out.println(code104.maxDepth(treeNode));
        System.out.println(code104.maxDepth2(treeNode));
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.right), maxDepth(root.left)) + 1;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
