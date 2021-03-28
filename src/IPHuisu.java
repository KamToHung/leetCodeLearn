import java.util.LinkedList;
import java.util.List;

/**
 * 93
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * <p>
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * <p>
 * 示例 3：
 * 输入：s = "1111"
 * 输出：["1.1.1.1"]
 * <p>
 * 示例 4：
 * 输入：s = "010010"
 * 输出：["0.10.0.10","0.100.1.0"]
 * <p>
 * 示例 5：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 *
 * @author Terry
 * @since 2020/8/27 16:27
 */
public class IPHuisu {

    List<String> result = new LinkedList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return result;
        }
        backtrack(s, 0, 0, new LinkedList<>());
        return result;
    }

    void backtrack(String s, int len, int start, List<String> nums) {
        if (nums.size() == 4) {
            if (len == s.length()) {
                result.add(String.join(".", nums));
            }
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i - 1 >= s.length()) {
                return;
            }
            String num = s.substring(start, start + i);
            if ((num.startsWith("0") && num.length() > 1) || Integer.parseInt(num) > 255) {
                return;
            }
            nums.add(num);
            len += num.length();
            backtrack(s, len, start + i, nums);
            len -= num.length();
            nums.remove(nums.size() - 1);
        }
    }

    public static void main(String[] args) {
        IPHuisu ipHuisu = new IPHuisu();
        System.out.println(ipHuisu.restoreIpAddresses("101023"));
    }
}
