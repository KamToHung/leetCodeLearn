package link;

/**
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 */
public class LeetCode2 {

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //直接循环链表相加即可
        ListNode node = new ListNode(0);
        ListNode cur = node;
        // 进位
        int addNum = 0;
        while (l1 != null || l2 != null) {
            // 因为有可能进一位，比如9999+1=10000，这种做法返回不正确
//            if (l1 == null) {
//                cur.next = l2;
//                break;
//            }
//            if (l2 == null) {
//                cur.next = l1;
//                break;
//            }
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = value1 + value2 + addNum;
            addNum = sum / 10;
            sum = sum % 10;
            ListNode nextNode = new ListNode(sum);
            cur.next = nextNode;
            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if(addNum != 0) {
            cur.next = new ListNode(addNum);
        }
        return node.next;
    }
}
