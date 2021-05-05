package link;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * Related Topics 链表
 */
public class ReverseLinkedListIi92 {

    public class ListNode {

        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode newNode = new ListNode(0);
        newNode.next = head;
        ListNode headNode = newNode;
        //找出开始的头节点
        for (int i = 0; i < m - 1; i++) {
            headNode = headNode.next;
        }
        ListNode tailNode = headNode.next;
        // 头之后的n-m个结点需要翻转
        ListNode pre = null;
        ListNode nxt = null;
        for (int i = 0; i < n - m + 1; i++) {
            nxt = tailNode.next;
            tailNode.next = pre;
            pre = tailNode;
            tailNode = nxt;
        }
        headNode.next.next = nxt;
        headNode.next = pre;
        return newNode.next;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return null;
        }
        ListNode first = head;
        ListNode last = head;
        for (int i = 0; i < k; i++) {
            // 不够K长度返回
            if (last == null) {
                return first;
            }
            last = last.next;
        }
        ListNode reverse = reverse(first, last);
        first.next = reverseKGroup(last, k);
        return reverse;
    }

    private ListNode reverse(ListNode first,ListNode last) {
        // 翻转两个节点之间的链表
        ListNode cur = first;
        ListNode next = null;
        ListNode pre = null;
        while (cur != last) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

}
