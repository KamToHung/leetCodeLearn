package number;

import java.util.function.Function;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * <p>
 * 示例 1：
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * <p>
 * 示例 2：
 * 输入：c = 3
 * 输出：false
 * <p>
 * 示例 3：
 * 输入：c = 4
 * 输出：true
 * <p>
 * 示例 4：
 * 输入：c = 2
 * 输出：true
 * <p>
 * 示例 5：
 * 输入：c = 1
 * 输出：true
 */
public class LeetCode633 {

    /**
     * 普通循环方法
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        // b = sqrt(c-a*a)
        // 循环a,a最大为sqrt(c)
        for (int a = 0; a <= Math.sqrt(c); a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用双指针
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum1(int c) {
        // left = 0,right=sqrt(c) 根据计算出来的数大小指针进行移动
        int left = 0;
        int right = (int) Math.sqrt(c) + 1;
        while (left < right) {
            int sum = left * left + right * right;
            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
