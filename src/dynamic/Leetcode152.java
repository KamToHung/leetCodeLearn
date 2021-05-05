package dynamic;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 *  示例 1:
 *  输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 *  示例 2:
 *  输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class Leetcode152 {

    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxMemo = 1;
        int minMemo = 1;
        for (int i = 0; i < nums.length; i++) {
            // 如果小于0，则最小值和最大值互换
            if (nums[i] < 0) {
                int temp = maxMemo;
                maxMemo = minMemo;
                minMemo = temp;
            }
            maxMemo = Math.max(maxMemo * nums[i], nums[i]);
            minMemo = Math.min(minMemo * nums[i], nums[i]);
            max = Math.max(maxMemo, max);
        }
        return max;
    }

}
