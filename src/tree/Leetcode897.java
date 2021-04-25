package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [5,1,7]
 * 输出：[1,null,5,null,7]
 */
public class Leetcode897 {

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

    private TreeNode results = new TreeNode();

    /**
     * 设置全局变量，改变tree结构即可
     *
     * @param root
     * @return
     */
    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode cur = results;
        order(root);
        return cur.right;
    }

    /**
     * 每次中序遍历修改指针引用
     *
     * @param root
     */
    private void order(TreeNode root) {
        if (root == null) {
            return;
        }
        order(root.left);
        results.right = root;
        // 左边要设置为null
        root.left = null;
        results = results.right;
        order(root.right);
    }





    public TreeNode increasingBST1(TreeNode root) {
        List<Integer> results = new ArrayList<>();
        // 先用中序遍历构建tree试下
        if (root == null) {
            return null;
        }
        TreeNode cur = new TreeNode();
        TreeNode head = cur;
        // 获取到中序遍历后的list
        order1(root, results);
        for (Integer value : results) {
            head.right = new TreeNode(value);
            head = head.right;
        }
        return cur.right;
    }

    // 中序遍历
    private void order1(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        order1(root.left, results);
        results.add(root.val);
        order1(root.right, results);
    }
}
