package leetcode.learn;

import java.util.List;

/**
 * 86
 *
 * @author Terry
 * @since 2020/9/14 18:30
 */
public class Fengelianbiao86 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nodeOne = new ListNode(0);
        ListNode nodeTwo = new ListNode(0);
        ListNode pre = nodeOne;
        ListNode tail = nodeTwo;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val >= 3) {
                tail.next = cur;
                cur = cur.next;
                tail = tail.next;
                tail.next = null;
            } else {
                pre.next = cur;
                cur = cur.next;
                pre = pre.next;
                pre.next = null;
            }
        }
        pre.next = nodeTwo.next;
        return nodeOne.next;
    }

    public static void main(String[] args) {

    }
}
