import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Terry
 * @since 2020/10/9 11:59
 */
public class TwoTree257 {

    private List<String> result = new ArrayList<>();

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root.left,root.right,new ArrayList<>());
        return result;
    }

    private void dfs(TreeNode left, TreeNode right, List<Integer> nums) {
        if (left == null && right == null) {
            result.add(nums.stream().map(String::valueOf).collect(Collectors.joining("->")));
            return;
        }
        if (left != null) {
            nums.add(left.val);
            dfs(left.left, left.right, nums);
            nums.remove(nums.size() - 1);
        }
        if (right != null) {
            nums.add(right.val);
            dfs(right.left, right.right, nums);
            nums.remove(nums.size() - 1);
        }
    }
}
