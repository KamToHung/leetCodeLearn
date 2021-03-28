/**
 * TODO
 *
 * @author Terry
 * @since 2020/10/23 17:27
 */
public class Tree112 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return dfs(root, sum, 0);
    }

    public boolean dfs(TreeNode root, int sum, int totalNum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return totalNum == sum;
        }
        boolean result = dfs(root.left, sum, totalNum + root.val);
        if (result) {
            return true;
        }
        result = dfs(root.right, sum, totalNum + root.val);
        if (result) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2);

        TreeNode n1 = new TreeNode(1);
        n1.left = n2;
        Tree112 tree112 = new Tree112();
        System.out.println(tree112.hasPathSum(n1, 1));
    }
}
