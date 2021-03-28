package dynamic;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 * 思路：我也是看了leetcode解释才懂···
 * 状态转移方程式：
 * 1.如果每次都会分解出j来，j是小于i大于1(0不是正整数，并且0相乘为0啊)的值，循环0<j<i
 * 找出 j*(i-j)的最大值 eg:i=6,j=3,那么f(i) = 3 * (6 - 3) = 9
 * 2.如果j*再次把i分解的数可能更大啊 eg:i=6,j=3 f(i) = f(i-j)*j f(i-j)意思是f(6-3)=f(3)的最大值,
 * 这时候f(i) = 3*f(6-3) = 3 * f(3) = 3 * 1 * 2 = 6, 小于不分解的情况了···
 * 所以我们得到：
 * f(i) = max(f(i), max(j*(i-j), j*f(i-j)) 这里需要加上max(f(i))是因为循环0<j<i的时候找出最大值
 * 出口：
 * f(0) = 1, f(1) = 1
 */
public class Leetcode343 {

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int maxValue = 0;
            for (int j = 1; j < i; j++) {
                int value = Math.max(j * (i - j), j * dp[i - j]);
                maxValue = Math.max(maxValue, value);
            }
            // 当前最大值
            dp[i] = maxValue;
        }
        return dp[n];
    }
}
