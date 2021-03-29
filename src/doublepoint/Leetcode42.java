package doublepoint;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == height.length
 * 0 <= n <= 3 * 104
 * 0 <= height[i] <= 105
 */
public class Leetcode42 {

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[left];
        int maxRight = height[right];
        int result = 0;
        while (left < right) {
            // 如果左边最高高度比右边低，则装最多水和左边相关，反之和右边高度相关
            if (maxLeft < maxRight) {
                result += maxLeft - height[left];
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                result += maxRight - height[right];
                right--;
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return result;
    }
}
