import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 239
 * 利用一个 双端队列，在队列中存储元素在数组中的位置， 并且维持队列的严格递减,，
 * 也就说维持队首元素是 **最大的 **，当遍历到一个新元素时, 如果队列里有比当前元素小的，
 * 就将其移除队列，以保证队列的递减。当队列元素位置之差大于 k，就将队首元素移除。
 *
 * @author Terry
 * @since 2020/9/21 10:17
 */
public class Huadong239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) {
            return new int[0];
        }
        int len = nums.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if (deque.getFirst() + k - 1 < i) {
                deque.removeFirst();
            }
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Huadong239 huadong239 = new Huadong239();
        int[] nums = {1, 3, -1, -3, 2, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(huadong239.maxSlidingWindow(nums, k)));
    }
}
