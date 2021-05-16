package bit;

/**
 * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
 * 进阶：你可以在 O(n) 的时间解决这个问题吗？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,10,5,25,2,8]
 * 输出：28
 * 解释：最大运算结果是 5 XOR 25 = 28.
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2,4]
 * 输出：6
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums = [8,10,2]
 * 输出：10
 * <p>
 * 示例 5：
 * <p>
 * 输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
 * 输出：127
 */
public class Leetcode421 {

    public int findMaximumXOR(int[] nums) {
        // 暴力
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int numI = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int numJ = nums[j];
                int num = numI ^ numJ;
                result = Math.max(result, num);
            }
        }
        return result;
    }
}
