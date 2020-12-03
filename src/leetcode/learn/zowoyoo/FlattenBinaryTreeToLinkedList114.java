package leetcode.learn.zowoyoo;

/**
 * 114
 * 给定一个二叉树，原地将它展开为一个单链表
 *
 * @author Terry
 * @since 2020/12/3 17:23
 */
public class FlattenBinaryTreeToLinkedList114 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = null;
        root.right = leftNode;
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = rightNode;
    }
}
