package leetcode.editor.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 145. 二叉树的后序遍历
 * 给定一个二叉树，返回它的 后序 遍历。
 * </p>
 *
 * @author edoup
 * @date 2020/12/23 1:52
 */
public class Code145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        postorderTraversal2(root, resList);
        return resList;
    }


    public void postorderTraversal2(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        }
        postorderTraversal2(root.left, resList);
        postorderTraversal2(root.right, resList);
        resList.add(root.val);
    }
}
