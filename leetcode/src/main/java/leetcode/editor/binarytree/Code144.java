package leetcode.editor.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 144. 二叉树的前序遍历
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 * </p>
 *
 * @author edoup
 * @date 2020/12/23 1:49
 */
public class Code144 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        preorderTraversal2(root, resList);
        return resList;
    }


    public void preorderTraversal2(TreeNode root, List<Integer> resList) {
        if (root == null) {
            return;
        }
        resList.add(root.val);
        preorderTraversal2(root.left, resList);
        preorderTraversal2(root.right, resList);
    }
}
