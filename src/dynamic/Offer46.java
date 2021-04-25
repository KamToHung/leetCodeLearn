package dynamic;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Offer46 {

    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < numStr.length() + 1; i++) {
            String result = numStr.substring(i - 2, i);
            // 如果不在10和25范围内，则不能组合新的字母
            if (result.compareTo("10") >= 0 && result.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[numStr.length()];
    }

}
