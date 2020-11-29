package leetcode.learn;

/**
 * 541
 *
 * @author Terry
 * @since 2020/9/7 15:59
 */
public class Fanzhuanzifuchuan2 {
    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        if (chs.length <= 1) {
            return s;
        }
        for (int i = 0; i < chs.length - 1; i = i + 2 * k) {
            int left = i;
            int right = Math.min(left + k - 1, chs.length - 1);
            while (left < right) {
                char temp = chs[left];
                chs[left++] = chs[right];
                chs[right--] = temp;
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        Fanzhuanzifuchuan2 fanzhuanzifuchuan2 = new Fanzhuanzifuchuan2();
        System.out.println(fanzhuanzifuchuan2.reverseStr("abcdefg", 8));
    }

}
