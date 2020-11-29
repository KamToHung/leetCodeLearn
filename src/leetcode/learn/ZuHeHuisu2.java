package leetcode.learn;

import java.util.*;

/**
 * 40
 *
 * @author Terry
 * @since 2020/8/25 14:54
 */
public class ZuHeHuisu2 {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(new LinkedList<>(), candidates, target, 0, 0);
        return result;
    }


    void backtrack(List<Integer> nums, int[] candidates, int target, int totalNum, int start) {
        if (totalNum > target) {
            return;
        }
        if (totalNum == target) {
            result.add(new LinkedList<>(nums));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i-1]) {
                continue;
            }
            int value = candidates[i];
            if (value > target) {
                continue;
            }
            nums.add(value);
            totalNum += value;
            backtrack(nums, candidates, target, totalNum, i+1);
            totalNum -= value;
            nums.remove(nums.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 1, 5};
        int target = 8;
        ZuHeHuisu2 zuheHuisu = new ZuHeHuisu2();
        System.out.println(zuheHuisu.combinationSum2(candidates, target));
    }
}