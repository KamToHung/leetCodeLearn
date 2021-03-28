import java.util.Arrays;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 说明：不允许修改给定的链表。
 * <p>
 * 示例 1：
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * <p>
 * <p>
 * 示例 2：
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * <p>
 * <p>
 * 示例 3：
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * @author Terry
 * @since 2020/9/11 14:25
 */
public class HuanxinglianbiaoTwo142 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public int[] findErrorNums(int[] nums) {
        int[] resule = new int[2];
        int[] temp = new int[nums.length+1];
        for(int num : nums) {
            temp[num]++;
        }

        for(int i = 1; i < temp.length; i++){
            if(temp[i] == 1)
                continue;
            if(temp[i] == 2)
                resule[0] = i;
            else
                resule[1] = i;
        }
        return resule;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        HuanxinglianbiaoTwo142 huanxinglianbiaoTwo142 = new HuanxinglianbiaoTwo142();
        System.out.println(Arrays.toString(huanxinglianbiaoTwo142.findErrorNums(nums)));
    }
}
