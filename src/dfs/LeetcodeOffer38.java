package dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class LeetcodeOffer38 {

    Set<String> result = new HashSet<>();

    public String[] permutation(String s) {
        dfs(s, new HashMap<>(), new StringBuilder());
        return result.toArray(new String[0]);
    }

    private void dfs(String s, Map<Integer, Integer> memo, StringBuilder builder) {
        if (s.length() == builder.length()) {
            result.add(builder.toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char value = s.charAt(i);
            if (memo.containsKey(i)) {
                continue;
            }
            memo.put(i, 0);
            builder.append(value);
            dfs(s, memo, builder);
            builder.deleteCharAt(builder.length() - 1);
            memo.remove(i);
        }
    }
}
