package leetcode.learn;

import java.util.LinkedList;
import java.util.List;

/**
 * 92
 *
 * @author Terry
 * @since 2020/9/7 10:22
 */
public class Npaixuhuisu {

    String result = "";

    int count = 0;

    public String getPermutation(int n, int k) {
        backtrack(n, k, new boolean[n + 1], new StringBuilder(n));
        return result;
    }

    private boolean backtrack(int n, int k, boolean[] memo, StringBuilder builder) {
        if (builder.length() == n) {
            count++;
            if (count == k) {
                result = builder.toString();
                return true;
            }
            return false;
        }
        for (int i = 1; i <= n; i++) {
            if (memo[i]) {
                continue;
            }
            memo[i] = true;
            builder.append(i);
            boolean backtrack = backtrack(n, k, memo, builder);
            if (backtrack) {
                return true;
            }
            builder.deleteCharAt(builder.length() - 1);
            memo[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Npaixuhuisu npaixuhuisu = new Npaixuhuisu();
        String permutation = npaixuhuisu.getPermutation(3, 3);
        System.out.println(permutation);
    }
}
