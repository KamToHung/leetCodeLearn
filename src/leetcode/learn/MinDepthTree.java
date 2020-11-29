package leetcode.learn;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * TODO
 *
 * @author Terry
 * @since 2020/8/24 14:19
 */
public class MinDepthTree {

    static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 1;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode left3 = new TreeNode(null, 3, null);

        TreeNode left2 = new TreeNode(left3, 10, null);
        TreeNode right2 = new TreeNode(null, 1, null);

        TreeNode left1 = new TreeNode(left2, 1, right2);

        TreeNode right1 = new TreeNode(null, 0, null);

        TreeNode root = new TreeNode(left1, 0, right1);
        System.out.println(minDepth(root));
    }

    static class TreeNode {

        TreeNode left;

        TreeNode right;

        int value;

        public TreeNode() {
        }

        public TreeNode(TreeNode left, int value, TreeNode right) {
            this.left = left;
            this.value = value;
            this.right = right;
        }
    }
}
