import java.util.LinkedList;
import java.util.List;

/**
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 *
 * @author Terry
 * @since 2020/8/25 15:39
 */
public class SevenSevenHuisu {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(new LinkedList<>(), n, k, 1);
        return result;
    }

    void backtrack(List<Integer> nums, int n, int k, int start) {
        if (nums.size() == k) {
            result.add(new LinkedList<>(nums));
            return;
        }
        for (int i = start; i <= n; i++) {
            nums.add(i);
            backtrack(nums, n, k, i + 1);
            nums.remove(nums.size() - 1);
        }
    }

    public static void main(String[] args) {
        SevenSevenHuisu sevenSevenHuisu = new SevenSevenHuisu();
        System.out.println(sevenSevenHuisu.combine(4, 2));
    }
}
