package dfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312"
 * 和 "192.168@1.1" 是 无效 IP 地址。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * <p>
 * 示例 4：
 * <p>
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * <p>
 * 示例 5：
 * <p>
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 */
public class Leetcode93 {

    private List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        dfs(s, 0, 0, new LinkedList<>());
        return result;
    }

    private void dfs(String s, int start, int len, Deque<String> nums) {
        // 如果数量刚好为4
        if (nums.size() == 4) {
            // 如果长度刚好和s相同
            if (len == s.length()) {
                result.add(String.join(".", nums));
            }
            return;
        }
        // 每次循环3次，因为每个段最大长度为3
        for (int i = 1; i <= 3; i++) {
            if (start + i > s.length()) {
                return;
            }
            String value = s.substring(start, start + i);
            // 剪枝
            if ((value.startsWith("0") && value.length() > 1) || Integer.parseInt(value) > 255) {
                return;
            }
            nums.add(value);
            len += value.length();
            dfs(s, start + i, len, nums);
            len -= value.length();
            nums.removeLast();
        }
    }
}
