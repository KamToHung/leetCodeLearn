package dynamic;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * <p>
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * <p>
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer14 {

    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        // 出口条件
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        // 定义dp为n长度的时候乘积最大的值
        // 转移方程式：f(x) = max(f(x-v(j))*j,(x-j)*j)
        for (int i = 3; i < n + 1; i++) {
            int max = 0;
            for (int j = 2; j < i; j++) {
                int value1 = dp[i - j] * j;
                int value2 = (i - j) * j;
                int maxValue = Math.max(value1, value2);
                max = Math.max(max, maxValue);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
