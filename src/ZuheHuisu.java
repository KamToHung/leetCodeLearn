import java.util.LinkedList;
import java.util.List;

/**
 * 39
 * candidates = [2,3,6,7], target = 7
 *
 * @author Terry
 * @since 2020/8/25 9:56
 */
public class ZuheHuisu {

    List<List<Integer>> result = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            nums.add(candidates[i]);
            totalNum += candidates[i];
            backtrack(nums, candidates, target, totalNum, i);
            totalNum -= candidates[i];
            nums.remove(nums.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        ZuheHuisu zuheHuisu = new ZuheHuisu();
        System.out.println(zuheHuisu.combinationSum(candidates,target));
    }
}
