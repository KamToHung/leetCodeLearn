package string;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 */
public class Leetcode5 {

    public String longestPalindrome1(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() < 2) {
            return s;
        }
        String maxLenStr = "";
        for (int i = 0; i < s.length(); i++) {
            String result1 = longestPalindrome1(s, i, i);
            maxLenStr = maxLenStr.length() > result1.length() ? maxLenStr : result1;
            String result2 = longestPalindrome1(s, i, i + 1);
            maxLenStr = maxLenStr.length() > result2.length() ? maxLenStr : result2;
        }
        return maxLenStr;
    }


    /**
     * 第一种中心扩展法
     *
     * @param s     字符串
     * @param left  首位左边扩展
     * @param right 首位右边扩展
     * @return
     */
    public String longestPalindrome1(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }


    /**
     * 第二种方法，动态规划
     * 动态转移方程式:
     * f(x,y) = f(x+1,y-1) && v(x) == v(y)   y - x => 3
     * 出口:
     * f(0,0) = true
     * f(x,y) = true y - x < 3
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() < 2) {
            return s;
        }
        int len = s.length();
        // 动态规划处理
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int length = 1;
        for (int j = 1; j < s.length(); j++) {
            // 右边
            char rightCh = s.charAt(j);
            for (int i = 0; i < j; i++) {
                // 左边
                char leftCh = s.charAt(i);
                // 如果左右不能肯定不是回文数
                if (rightCh != leftCh) {
                    dp[i][j] = false;
                } else {
                    if (j - i <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 如果为true,记录最长长度
                if (dp[i][j]) {
                    if (length < j - i + 1) {
                        start = i;
                        length = j - i + 1;
                    }
                }
            }
        }
        return s.substring(start, start + length);
    }

}
