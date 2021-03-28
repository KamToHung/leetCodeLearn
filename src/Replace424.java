/**
 * 424
 *
 * @author Terry
 * @since 2020/9/18 16:55
 */
public class Replace424 {

    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char first = s.charAt(0);
        int left = 0;
        int right = 1;
        int count = 0;
        int maxLen = 0;
        int endLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            if (c != first) {
                count++;
            }
            while (count > k) {
                while (s.charAt(left) == first) {
                    left++;
                }
                right = left;
                first = s.charAt(left);
                count = 0;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            if (right == s.length() - 1) {
                endLen = right - left + 1;
            }
            right++;
        }
        //因为还有一些剩余的,可以由left往前推count次
        if (count < k) {
            while (left > 0) {
                left--;
                if (first != s.charAt(left) && count < 2) {
                    count++;
                    endLen++;
                }
            }
        }
        return Math.max(maxLen, endLen);
    }

    private int[] map = new int[26];

    public int characterReplacementNew(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int right = 0;
        int left = 0;
        int maxNum = 0;
        int len = 0;
        int[] memo = new int[26];
        while (right < s.length()) {
            char c = s.charAt(right);
            memo[c - 'A']++;
            maxNum = Math.max(maxNum, memo[c - 'A']);
            while (right - left + 1 - maxNum > k) {
                char d = s.charAt(left);
                memo[d - 'A']--;
                left++;
            }
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    public int characterReplacementNewNew(String s, int k) {
        int[] window = new int[26];

        int right = 0, left = 0, freq = 0, len = 0;

        char[] str = s.toCharArray();

        while (right < str.length) {
            int ch = str[right++] - 'A';
            window[ch]++;
            freq = Math.max(window[ch], freq);

            while (right - left - freq > k) {
                ch = str[left++] - 'A';
                window[ch]--;

            }
            len = Math.max(len, right - left);
        }
        return len;
    }


    public static void main(String[] args) {
        Replace424 replace424 = new Replace424();
        System.out.println(replace424.characterReplacementNewNew("AABACCA", 2));
    }
}
