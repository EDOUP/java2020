package leetcode.editor;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/1 0:04
 */
public class Code111 {

    public static void main(String[] args) {

    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedBlockingQueue<>();
        Set<TreeNode> v = new HashSet<>();

        q.offer(root);
        v.add(root);
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = q.poll();
                if (poll.left == null && poll.right == null) {
                    return step;
                }
                if (poll.left != null) {
                    q.offer(poll.left);
                }
                if (poll.right != null) {
                    q.offer(poll.right);
                }
                step++;
            }
        }

        return -1;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) return 0;

        if (root.right == null && root.left == null) {
            return 1;
        }
        int depth = Integer.MAX_VALUE;
        if (root.right != null) {
            return Math.min(1 + minDepth2(root.right), depth);
        }
        if (root.left != null) {
            return Math.min(1 + minDepth2(root.left), depth);
        }
        return depth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


