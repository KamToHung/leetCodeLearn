package dynamic;

/**
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 * 示例 1：
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * <p>
 * 示例 2：
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * <p>
 * 示例 3：
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 */
public class Leetcode1269 {

    public int numWays(int steps, int arrLen) {
        // 1 2 3 4 5     5
        // 可以使用动态规划处理
        // 状态转移方程式:
        // x为当前操作数，y为当前操作位置的所有方案数
        // f(x,y) = f(x,y) + f(x+1,y) 原地不动
        // f(x,y) = f(x,y) + f(x+1,y+1) 向左移一位状态来的
        // f(x,y) = f(x,y) + f(x+1,y-1) 向右移动一位状态来的
        // 出口: f(steps,0) = 1 当前初始的操作数不动，方案数为1
        // 这里是最长能到达位置，因为我需要来回所以除以二了
        int maxLen = Math.min(steps / 2, arrLen - 1);
        int[][] dp = new int[steps + 1][maxLen + 1];
        dp[steps][0] = 1;
        for (int i = steps - 1; i >= 0; i--) {
            for (int j = 0; j <= maxLen; j++) {
                dp[i][j] = (dp[i][j] + dp[i + 1][j]) % 1000000007;
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i + 1][j - 1]) % 1000000007;
                }
                if (j + 1 <= maxLen) {
                    dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % 1000000007;
                }
            }
        }
        return dp[0][0];
    }
}
