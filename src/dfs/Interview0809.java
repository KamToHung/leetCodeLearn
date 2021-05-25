package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Interview0809 {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(n, 0, 0, new StringBuilder());
        return result;
    }

    private void dfs(int n, int left, int right, StringBuilder builder) {
        // 如果n=left=right则保存，left为左括号数量，right为右括号数量
        if (left == right && right == n) {
            result.add(builder.toString());
            return;
        }
        if (left > n && right > n) {
            return;
        }
        // 加上括号，但是要保证括号有效
        if (left < n) {
            builder.append('(');
            dfs(n, left + 1, right, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (right < left) {
            builder.append(')');
            dfs(n, left, right + 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
