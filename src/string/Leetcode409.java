package string;

import javax.management.remote.rmi._RMIConnection_Stub;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "abccccdd"
 * <p>
 * 输出:
 * 7
 * <p>
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 */
public class Leetcode409 {

    public int longestPalindrome(String s) {
        // 一个字符串里面找出可以组成回文字符串，则所有偶数的相加，加上一个奇数即可
        Map<Character, Integer> memo = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int count = memo.getOrDefault(ch, 0);
            memo.put(ch, count + 1);
        }
        // 证明只有一个数，则就是结果长度
        if (memo.size() == 1) {
            return memo.values().stream().findFirst().get();
        }
        // 对于奇数处理，保留一个1，如果大于1的保留-1个数即可
        boolean flag = true;
        int count = 0;
        for (Map.Entry<Character, Integer> entry : memo.entrySet()) {
            int value = entry.getValue();
            if (value % 2 != 0) {
               if (flag) {
                   count++;
               }
               count += value - 1;
               flag = false;
            } else {
                count += value;
            }
        }
        return count;
    }
}
