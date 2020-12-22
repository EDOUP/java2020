package leetcode.editor.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 94. 二叉树的中序遍历
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * </p>
 *
 * @author edoup
 * @date 2020/12/23 1:39
 */
public class Code94 {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> reslist = new ArrayList<>();
        inorderTraversal2(root, reslist);
        return reslist;
    }

    private void inorderTraversal2(TreeNode root, List<Integer> reslist) {
        if (root == null) {
            return;
        }
        inorderTraversal2(root.left, reslist);
        reslist.add(root.val);
        inorderTraversal2(root.right, reslist);
    }

}
