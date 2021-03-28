package dynamic;

import java.util.Arrays;

/**
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 示例：
 * <p>
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给出数对的个数在 [1, 1000] 范围内。
 * 思路类似300
 */
public class Leetcode646 {

    /**
     * 贪心算法
     *
     * @param pairs
     * @return
     */
    public int findLongestChain1(int[][] pairs) {
        int m = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[1] - b[1]));
        int temp = pairs[0][1];
        int num = 1;
        for (int i = 1; i < m; i++) {
            if (pairs[i][0] > temp) {
                num++;
                temp = pairs[i][1];
            }
        }
        return num;
    }

    /**
     * 动态规划
     *
     * @param pairs
     * @return
     */
    public int findLongestChain(int[][] pairs) {
        int m = pairs.length;
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        int[] dp = new int[m];
        int max = 1;
        for (int i = 0; i < m; i++) {
            int maxValue = 1;
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    int value = dp[j] + 1;
                    maxValue = Math.max(value, maxValue);
                }
            }
            dp[i] = maxValue;
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
