package dynamic;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3
 * 列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * 思路：
 * 当前为i的时候，我们需要找出0<j<i之间的数最长长度 + 1，即是f(i)
 * 状态转移方程式：
 * f(i) = f(j) + 1 0<j<i && nums[j] < nums[i],
 * 我们还是要比较初始f(i)和f(j) + 1哪个长
 * 出口：
 * f(i) = 1，每个位置递增子序列的长度至少为1
 */
public class Leetcode300 {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int curMax = dp[i];
            for (int j = 0; j < i && nums[j] < nums[i]; j++) {
                // 状态转移方程式
                curMax = Math.max(curMax, dp[j] + 1);
            }
            dp[i] = curMax;
            max = Math.max(max, curMax);
        }
        return max;
    }
}
