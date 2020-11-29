package leetcode.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target
 * d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 *
 * @author Terry
 * @since 2020/9/9 14:52
 */
public class Sishuzhihe18 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (j > i + 1 && (nums[j] == nums[j - 1])) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    //如果和上一次相同则跳过
                    if ((left > j + 1) && (nums[left] == nums[left - 1])) {
                        left++;
                        continue;
                    }
                    if (nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left++;
                    } else if (nums[i] + nums[j] + nums[left] + nums[right] == target) {
                        List<Integer> numbers = new ArrayList<>(4);
                        numbers.add(nums[i]);
                        numbers.add(nums[j]);
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
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        Sishuzhihe18 sanshuhe15 = new Sishuzhihe18();
        List<List<Integer>> lists = sanshuhe15.fourSum(nums,-11);
        System.out.println(lists);
    }
}
