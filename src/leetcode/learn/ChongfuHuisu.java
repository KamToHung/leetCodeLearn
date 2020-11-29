package leetcode.learn;

import java.util.*;

/**
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 *
 * @author Terry
 * @since 2020/8/25 17:12
 */
public class ChongfuHuisu {

    Set<String> result = new HashSet<>();

    public String[] permutation(String S) {
        backtrack(S, new StringBuilder(), new boolean[S.length()]);
        return result.toArray(new String[result.size()]);
    }

    void backtrack(String S, StringBuilder builder, boolean[] flag) {
        if (S.length() == builder.length()) {
            result.add(builder.toString());
            return;
        }
        for (int i = 0; i < S.length(); i++) {
            if (flag[i]) {
                continue;
            }
            char c = S.charAt(i);
            builder.append(c);
            flag[i] = true;
            backtrack(S, builder, flag);
            flag[i] = false;
            builder.deleteCharAt(builder.length() - 1);
        }
    }

    public static void main(String[] args) {
        ChongfuHuisu chongfuHuisu = new ChongfuHuisu();
        System.out.println(Arrays.toString(chongfuHuisu.permutation("qqe")));
    }
}
