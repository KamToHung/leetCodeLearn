package dynamic;

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
