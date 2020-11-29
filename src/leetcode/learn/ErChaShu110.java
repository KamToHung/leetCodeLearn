package leetcode.learn;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * 110
 *
 * @author Terry
 * @since 2020/10/19 17:23
 */
public class ErChaShu110 {

    private boolean isBalanced = true;

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

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }
        return left > right ? left + 1 : right + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        getDepth(root);
        return isBalanced;
    }

    public static void main(String[] args) {
//        ErChaShu110 erChaShu110 = new ErChaShu110();
//
//        ErChaShu110.TreeNode n4 = new ErChaShu110.TreeNode(4);
//
//        ErChaShu110.TreeNode n7 = new ErChaShu110.TreeNode(7);
//
//        ErChaShu110.TreeNode n8 = new ErChaShu110.TreeNode(8);
//
//        ErChaShu110.TreeNode n5 = new ErChaShu110.TreeNode(5, n7, n8);
//
//        ErChaShu110.TreeNode n2 = new ErChaShu110.TreeNode(2, n4, n5);
//
//        ErChaShu110.TreeNode n6 = new ErChaShu110.TreeNode(6);
//
//        ErChaShu110.TreeNode n3 = new ErChaShu110.TreeNode(3, null, n6);
//
//        ErChaShu110.TreeNode n1 = new ErChaShu110.TreeNode(1, n2, n3);
//
//        System.out.println(erChaShu110.isBalanced(n1));
        HashMap<String, Object> map = new HashMap<>();
        map.put("supplierPrice",100);
        double supplierPrice = Double.parseDouble(String.valueOf(map.get("supplierPrice")));

        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(supplierPrice));
    }
}
