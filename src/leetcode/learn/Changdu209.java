package leetcode.learn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Terry
 * @since 2020/9/15 16:45
 */
public class Changdu209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int size = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                int len = right - left + 1;
                size = Math.min(len, size);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }

    public int minSubArrayLenNew(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        int size = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s) {
                int len = right - left + 1;
                size = Math.min(len, size);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return size == Integer.MAX_VALUE ? 0 : size;
    }

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> memo = new HashMap<>();
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            int count = memo.getOrDefault(c, 0) + 1;
            memo.put(c, count);
            while (memo.getOrDefault(c, 0) > 1) {
                char d = s.charAt(left);
                memo.put(d, memo.getOrDefault(d, 0) - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

}
