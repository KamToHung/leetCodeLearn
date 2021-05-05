package tree;


/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class LeetCode109 {

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

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public TreeNode sortedListToBST(ListNode head) {
        return order(head, null);
    }

    public TreeNode order(ListNode leftNode, ListNode rightNode) {
        if (leftNode == rightNode) {
            return null;
        }
        ListNode midNode = midNode(leftNode, rightNode);
        TreeNode node = new TreeNode(midNode.val);
        node.left = order(leftNode, midNode);
        node.right = order(midNode.next, rightNode);
        return node;
    }

    private ListNode midNode(ListNode leftNode, ListNode rightNode) {
        // 链表找中间节点可以使用快慢指针
        ListNode fast = leftNode;
        ListNode slow = leftNode;
        while (fast != rightNode && fast.next != rightNode) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
