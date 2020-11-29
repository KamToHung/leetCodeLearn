package leetcode.learn;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *
 * @author Terry
 * @since 2020/8/24 18:47
 */
public class HuisuPhone {

    List<String> result = new LinkedList<>();

    static Map<Character, String> numberMap = new HashMap<>(9);

    static {
        numberMap.put('2', "abc");
        numberMap.put('3', "def");
        numberMap.put('4', "ghi");
        numberMap.put('5', "jkl");
        numberMap.put('6', "mno");
        numberMap.put('7', "pqrs");
        numberMap.put('8', "tuv");
        numberMap.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder());
        return result;
    }

    public void backtrack(String digits, int i, StringBuilder builder) {
        if (digits.length() == builder.length()) {
            result.add(builder.toString());
            return;
        }
        String value = numberMap.get(digits.charAt(i));
        for (int j = 0; j < value.length(); j++) {
            builder.append(value.charAt((j)));
            backtrack(digits, i + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        HuisuPhone huisuPhone = new HuisuPhone();
        System.out.println(huisuPhone.letterCombinations("23"));
    }
}
