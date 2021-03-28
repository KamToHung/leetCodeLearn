package dynamic;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 * 示例 1：
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * <p>
 * 思路：第i个楼梯为第i-1和第i-2个楼梯之和
 * 出口：
 * dp[1] = 1;
 * dp[2] = 2;
 * 状态转移方程式：
 * dp[i] = dp[i-1] + dp[i-2]
 */
public class Leetcode70 {

    /**
     * 普通模式，直接dp数组解决
     *
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 优化，只用两个变量即可存储
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;
        int next = 2;
        for (int i = 2; i < n; i++) {
            int cur = first + next;
            first = next;
            next = cur;
        }
        return next;
    }


    public static void main(String[] args) {
        Leetcode70 leetcode70 = new Leetcode70();
        System.out.println(leetcode70.climbStairs(10));
    }

}
