package tree;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class Offer26 {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return dfs(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean dfs(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        // B不为空但是A为空
        if (A == null) {
            return false;
        }
        int valueA = A.val;
        int valueB = B.val;
        if (valueA != valueB) {
            return false;
        }
        // 递归左右节点是否相同
        return dfs(A.left, B.left) && dfs(A.right, B.right);
    }

}
