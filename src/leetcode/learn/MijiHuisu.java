package leetcode.learn;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入： nums = [1,2,3]
 * 输出：
 * [
 * [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * @author Terry
 * @since 2020/8/25 17:00
 */
public class MijiHuisu {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(new LinkedList<>(), nums, 0);
        return result;
    }

    void backtrack(List<Integer> cild, int[] nums, int start) {
        result.add(new LinkedList<>(cild));
        for (int i = start; i < nums.length; i++) {
            cild.add(nums[i]);
            backtrack(cild, nums, i + 1);
            cild.remove(cild.size() - 1);
        }
    }

    public static void main(String[] args) {
        MijiHuisu mijiHuisu = new MijiHuisu();
        System.out.println(mijiHuisu.subsets(new int[]{1,2,3}));
    }
}
