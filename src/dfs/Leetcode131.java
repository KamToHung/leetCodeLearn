package dfs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * s 仅由小写英文字母组成
 */
public class Leetcode131 {

    private List<List<String>> result = new LinkedList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return result;
        }
        dfs(s,0,0,new LinkedList<>());
        return result;
    }

    private void dfs(String s, int start, int len, Deque<String> path) {
        if (s.length() == len) {
            result.add(new LinkedList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 如果不符合则跳过
            if (!isValid(s, start, i)) {
                continue;
            }
            String value = s.substring(start, i + 1);
            path.addLast(value);
            dfs(s, i + 1, i + 1, path);
            path.removeLast();
        }
    }

    private boolean isValid(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
