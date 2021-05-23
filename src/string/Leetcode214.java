package string;

public class Leetcode214 {

    public String shortestPalindrome(String s) {
        String reserveStr = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < reserveStr.length(); i++) {
            if (s.startsWith(reserveStr.substring(i))) {
                return reserveStr.substring(0, i) + s;
            }
        }
        return "";
    }

}
