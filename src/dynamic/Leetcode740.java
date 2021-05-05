package dynamic;

/**
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] +
 * 1 的元素。
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 */
public class Leetcode740 {

    public int deleteAndEarn(int[] nums) {
        int len = 10 * 10 * 10 * 10 + 1;
        // 设置为里面的数作为数组下标，值是相同值加起来的值
        int[] memo = new int[len];
        for (int i = 0; i < nums.length; i++) {
            memo[nums[i]] += nums[i];
        }
        // 打家劫舍问题
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = memo[1];
        for (int i = 2; i < len; i++) {
            // 选i删除
            int value1 = dp[i - 2] + memo[i];
            // 不选i删除
            int value2 = dp[i - 1];
            dp[i] = Math.max(value1, value2);
        }
        return dp[len - 1];
    }
}
