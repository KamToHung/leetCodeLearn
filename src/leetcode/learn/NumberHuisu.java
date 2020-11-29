package leetcode.learn;

import java.util.LinkedList;
import java.util.List;

/**
 * TODO
 *
 * @author Terry
 * @since 2020/8/21 15:28
 */
public class NumberHuisu {

    static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> path = new LinkedList<>();
        backtrack(res, nums, path);
        return res;
    }

    static void backtrack(List<List<Integer>> res, int[] nums, List<Integer> path) {
        // 排序长度
        int length = nums.length;
        //如果相等,代表已经遍历完毕
        if (length == path.size()) {
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backtrack(res, nums, path);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permute = permute(nums);
        System.out.println(permute);
    }
}
