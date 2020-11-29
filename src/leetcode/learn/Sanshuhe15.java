package leetcode.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元
 * 的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 *
 * @author Terry
 * @since 2020/9/8 18:25
 */
public class Sanshuhe15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                //如果和上一次相同则跳过
                if ((left > i + 1) && (nums[left] == nums[left - 1])) {
                    left++;
                    continue;
                }
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> numbers = new ArrayList<>();
                    numbers.add(nums[i]);
                    numbers.add(nums[left]);
                    numbers.add(nums[right]);
                    result.add(numbers);
                    left++;
                    right--;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Sanshuhe15 sanshuhe15 = new Sanshuhe15();
        List<List<Integer>> lists = sanshuhe15.threeSum(nums);
        System.out.println(lists);
    }
}
