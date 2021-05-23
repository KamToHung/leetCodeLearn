package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Offer48 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int max = 0;
        Map<Character, Integer> memo = new HashMap<>();
        char[] chs = s.toCharArray();
        while (right < len) {
            char ch = chs[right];
            int count = memo.getOrDefault(ch, 0);
            memo.put(ch, count + 1);
            while (memo.get(ch) > 1) {
                // 如果有重复的，则左边需要往右移
                char leftValue = chs[left];
                int leftCount = memo.get(leftValue);
                memo.put(leftValue, leftCount - 1);
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        // abcbc
        int max = 0;
        int left = 0;
        int right = 0;
        // 维护不重复字符串
        Set<Character> memo = new HashSet<>();
        while (right < s.length()) {
            // 滑动窗口
            char ch = s.charAt(right);
            if (memo.contains(ch)) {
                // 移除左边
                char leftCh = s.charAt(left);
                memo.remove(leftCh);
                left++;
            }
            memo.add(ch);
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int left = 0;
        Set<Character> memo = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            while (memo.contains(ch)) {
                memo.remove(s.charAt(left));
                left++;
            }
            memo.add(ch);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
