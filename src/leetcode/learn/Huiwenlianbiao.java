package leetcode.learn;

import java.util.List;

/**
 * 请判断一个链表是否为回文链表。
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 * <p>
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 * Related Topics 链表 双指针
 *
 * @author Terry
 * @since 2020/9/7 17:43
 */
public class Huiwenlianbiao {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode low = p;
        ListNode fast = p;
        while (fast != null && fast.next != null) {
            low = low.next;
            fast = fast.next.next;
        }
        ListNode cur = low.next;
        low.next = null;
        low = p.next;
        //反转
        ListNode pre = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        while (pre != null) {
            if (pre.val != low.val) {
                return false;
            }
            pre = pre.next;
            low = low.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(1);
//        ListNode five = new ListNode(1);
        head.next = two;
        two.next = three;
        three.next = four;
//        four.next = five;
        Huiwenlianbiao huiwenlianbiao = new Huiwenlianbiao();
        boolean palindrome = huiwenlianbiao.isPalindrome(head);
        System.out.println(palindrome);
    }
}
