package dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 * <p>
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * 思路：
 * 先找出小于n的平方数，组装成为一个数据，接下来就是01背包问题了
 * 状态转移方程式：
 * 如果我选n，则f(n) = f(n-j) + 1 ,f(n-j)意思是比如12，我现在j=4，那么我要获得f(8)的最小平方数。这时候f(8) + 1 = f(12)了
 * 如果我不选n，则f(n) = n,当全部都是1的时候，平方数最大吧。
 * 出口：
 * f(1) = 1,即1的时候为1
 */
public class Leetcode279 {
    public int numSquares(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        // 放入平方数
        List<Integer> square = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (i * i <= n) {
                square.add(i * i);
            }
        }
        int squareSize = square.size();
        for (int i = 2; i < n + 1; i++) {
            // 当所有都为1的时候，这时候平方数数量最多
            int minValue = i;
            for (int j = 0; j < squareSize; j++) {
                // 如果i比平方数小，跳过
                if (i < square.get(j)) {
                    continue;
                }
                //eg:如果i为12，平方数为4，则f(12)=f(8) + 1,f(8)的最小数+1就是f(12)了
                int value = dp[i - square.get(j)] + 1;
                minValue = Math.min(minValue, value);
            }
            dp[i] = minValue;
        }
        return dp[n];
    }
}
