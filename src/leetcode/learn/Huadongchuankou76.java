package leetcode.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * 76
 *
 * @author Terry
 * @since 2020/9/16 15:23
 */
public class Huadongchuankou76 {

//    public String minWindow(String s, String t) {
//        Map<Character, Integer> need = new HashMap<>();
//        Map<Character, Integer> window = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            need.put(c, need.getOrDefault(c, 0) + 1);
//        }
//        int left = 0, right = 0;
//        int valid = 0;
//        // 记录最小覆盖子串的起始索引及长度
//        int start = 0, len = Integer.MAX_VALUE;
//        while (right < s.length()) {
//            // c 是将移入窗口的字符
//            char c = s.charAt(right);
//            // 右移窗口
//            right++;
//            // 进行窗口内数据的一系列更新
//            if (need.containsKey(c)) {
//                window.put(c, window.getOrDefault(c, 0) + 1);
//                if (window.get(c).equals(need.get(c)))
//                    valid++;
//            }
//            // 判断左侧窗口是否要收缩
//            while (valid == need.size()) {
//                // 在这里更新最小覆盖子串
//                if (right - left < len) {
//                    start = left;
//                    len = right - left;
//                }
//                // d 是将移出窗口的字符
//                char d = s.charAt(left);
//                // 左移窗口
//                left++;
//                // 进行窗口内数据的一系列更新
//                if (need.containsKey(d)) {
//                    if (window.get(d).equals(need.get(d)))
//                        valid--;
//                    window.put(d, window.getOrDefault(d, 0) - 1);
//                }
//            }
//        }
//        // 返回最小覆盖子串
//        return len == Integer.MAX_VALUE ?
//                "" : s.substring(start, start + len);
//    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        Map<Character, Integer> tNum = new HashMap<>();
        Map<Character, Integer> sNum = new HashMap<>();
        int left = 0;
        int start = 0;
        int right = 0;
        int totalNum = 0;
        int min = Integer.MAX_VALUE;
        //先保存tNum
        for (char ch : t.toCharArray()) {
            tNum.put(ch, tNum.getOrDefault(ch, 0) + 1);
        }
        while (right < s.length()) {
            char c = s.charAt(right);
            if (tNum.containsKey(c)) {
                sNum.put(c, sNum.getOrDefault(c, 0) + 1);
                if (sNum.get(c).equals(tNum.get(c))) {
                    totalNum++;
                }
            }
            while (totalNum == tNum.size()) {
                if (right - left < min) {
                    min = right - left + 1;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if (sNum.containsKey(d)) {
                    if (sNum.get(d).equals(tNum.get(d))) {
                        totalNum--;
                    }
                    sNum.put(d, sNum.getOrDefault(d, 0) - 1);
                }
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }

    public static void main(String[] args) {
        Huadongchuankou76 huadongchuankou76 = new Huadongchuankou76();
        System.out.println(huadongchuankou76.minWindow("a", "b"));
    }
}
