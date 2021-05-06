package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。
 * 请你找出并返回那个只出现了一次的元素。
 */
public class LeetCode137 {

    /**
     * 暴力算法
     * 可以使用位运算，但是不会
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        for (int num : nums) {
            int count = memo.getOrDefault(num, 0);
            memo.put(num, count+1);
        }
        for (Map.Entry<Integer, Integer> num : memo.entrySet()) {
            if (num.getValue() == 1) {
                return num.getKey();
            }
        }
        return 0;
    }
}
