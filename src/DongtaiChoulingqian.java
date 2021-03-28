/**
 * 凑零钱问题
 *
 * @author Terry
 * @since 2020/8/20 18:46
 */
public class DongtaiChoulingqian {

    // coins 中是可选硬币⾯值，amount 是⽬标⾦额
    static int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for (int i = 0; i < amount + 1; i++) {
            memo[i] = Integer.MAX_VALUE;
        }
        memo[0] = 0;
        for (int i = 0; i < memo.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                memo[i] = Math.min(memo[i],1+memo[i-coin]);
            }
        }
        if (memo[amount] ==Integer.MAX_VALUE) {
            return -1;
        }
        return memo[amount];
    }

    static int dp(int[] memo, int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dp = dp(memo, coins, amount - coin);
            if (dp < 0) {
                continue;
            }
            result = Math.min(result, 1 + dp);
        }
        if (result == Integer.MAX_VALUE) {
            return -1;
        }
        memo[amount] = result;
        return memo[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}
