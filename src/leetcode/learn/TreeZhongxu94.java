package leetcode.learn;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 94
 *
 * @author Terry
 * @since 2020/9/24 10:30
 */
public class TreeZhongxu94 {

    public static class TreeNode {
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }


    public static void main(String[] args) {
        TreeZhongxu94 treeZhongxu94 = new TreeZhongxu94();
        TreeNode n1 = new TreeNode(1);

        TreeNode n2 = new TreeNode(2, n1, null);

        TreeNode n4 = new TreeNode(4);

        TreeNode n3 = new TreeNode(3, n2, n4);

        TreeNode n6 = new TreeNode(6);

        TreeNode n8 = new TreeNode(8);

        TreeNode n7 = new TreeNode(7, n6, n8);

        TreeNode n5 = new TreeNode(5, n3, n7);
        System.out.println(treeZhongxu94.inorderTraversal(n5));
    }
}
