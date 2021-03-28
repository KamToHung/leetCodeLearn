/**
 * 92
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * 示例:
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * Related Topics 链表
 *
 * @author Terry
 * @since 2020/9/4 16:15
 */
public class Fanzhuanlianbiao {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode node = result;
        //找出需要反转的头结点
        for (int i = 1; i < m; i++) {
            node = node.next;
        }
        //需要反转的结点 2
        ListNode nextNode = node.next;
        //下面需要旋转m-n之间的结点
        //保存前结点
        ListNode pre = null;
        ListNode tail = null;
        for (int i = 0; i <= (n - m); i++) {
            //下一个  3   4
            tail = nextNode.next;
            //下一个结点的next   null 2
            nextNode.next = pre;
            //保存当前结点 2 3
            pre = nextNode;
            //作为首结点 3 4
            nextNode = tail;
        }
        node.next.next = tail;
        node.next = pre;
        return result.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        Fanzhuanlianbiao fanzhuanlianbiao = new Fanzhuanlianbiao();
        ListNode listNode = fanzhuanlianbiao.reverseBetween(head, 2, 4);
        System.out.println(listNode);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
