package dynamic;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没
 * -1。
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * <p>
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * 思路：
 * 状态转移方程式：
 * n为需要加上的硬币面值
 * f(i) = f(i - n) + 1  n <= i 需要所有面值加起来数量最小值
 * 出口：
 * f(0) = 0;
 */
public class Leetcode322 {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int maxValue = amount + 1;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    int value = dp[i - coins[j]] + 1;
                    maxValue = Math.min(maxValue, value);
                }
            }
            dp[i] = maxValue;
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
