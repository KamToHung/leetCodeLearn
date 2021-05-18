package tree;

/**
 * 计算给定二叉树的所有左叶子之和。
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Leetcode404 {

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

    // 计算总数
    private int result = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        // 找出结束条件
        if (root == null) {
            return 0;
        }
        // 找出处理逻辑。逻辑就是判断是否左(叶子)!节点，是的话加上
        if (root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                result += root.left.val;
            }
        }
        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return result;
    }
}
