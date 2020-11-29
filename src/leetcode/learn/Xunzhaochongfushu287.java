package leetcode.learn;

import java.util.Arrays;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和
 * 这个重复的数。
 * 示例 1:
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * <p>
 * 说明：
 * <p>
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * @author Terry
 * @since 2020/9/11 11:16
 */
public class Xunzhaochongfushu287 {

    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        int maxNumber = nums[nums.length - 1];
        int[] memo = new int[maxNumber + 1];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (memo[num] == 0) {
                memo[num] = num;
            } else {
                return num;
            }
        }
        return 1;
    }

    public int findDuplicateNew(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        Xunzhaochongfushu287 xunzhaochongfushu287 = new Xunzhaochongfushu287();
        int[] nums = {1, 2, 2};
        System.out.println(xunzhaochongfushu287.findDuplicate(nums));
    }
}
