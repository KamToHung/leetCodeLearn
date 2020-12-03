package leetcode.learn.zowoyoo;

/**
 * 226
 * 翻转一棵二叉树
 *
 * @author Terry
 * @since 2020/12/3 16:53
 */
public class InvertBinaryTree226 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


}
