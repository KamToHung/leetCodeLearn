package dynamic;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影
 * 被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置
 * <p>
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * 思路：
 * 状态转移方程式：
 * 如果选择偷i，那么f(i) = f(i-2) + price(i)
 * 如果选择不偷i，那么f(i) = f(i-1)
 * 以上两种情况最大值则为抢得最多
 * 出口：
 * f(0) = price(0)
 * f(1) = max(price(0),price(1))
 */
public class Leetcode198 {

    /**
     * 传统dp
     *
     * @param nums
     * @return
     */
    public int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int robI = dp[i - 2] + nums[i];
            int noRobI = dp[i - 1];
            dp[i] = Math.max(robI, noRobI);
        }
        return dp[nums.length - 1];
    }

    /**
     * 简单dp
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        // 偷的第一家
        int first = 0;
        // 偷的第二家
        int next = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(first + nums[i], next);
            first = next;
            next = cur;
        }
        return next;
    }

    public static void main(String[] args) {
        Leetcode198 leetcode198 = new Leetcode198();
        int[] arr = {2, 7, 9, 3, 1};
        System.out.println(leetcode198.rob(arr));
    }
}
