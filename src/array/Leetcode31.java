package array;

import java.util.Arrays;

/**
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序
 * 必须 原地 修改，只允许使用额外常数空间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 思路
 * 找到nums[i] 比nums[i+1]小的时候，
 * 就将nums[i]跟nums[i+1]到nums[nums.length - 1]当中找到一个最小的比nums[i]大的元素交换。
 * 交换后，再把nums[i+1]到nums[nums.length-1]排序
 */
public class Leetcode31 {

    public void nextPermutation(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                left = i;
            }
        }
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[i] > nums[left]) {
                right = i;
            }
        }
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        Arrays.sort(nums, left + 1, nums.length);
    }
}
