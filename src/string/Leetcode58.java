package string;


/**
 * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0 。
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello World"
 * 输出：5
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = " "
 * 输出：0
 */
public class Leetcode58 {

            public int lengthOfLastWord(String s) {
                if (s == null || s.length() == 0) {
                    return 0;
                }
                s = s.trim();
                int len = 0;
                for (int i = s.length() - 1; i >= 0; i--) {
                    char ch = s.charAt(i);
                    if (ch == ' ') {
                        break;
                    }
                    len++;
                }
                return len;
            }
}
