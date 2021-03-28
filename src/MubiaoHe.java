/**
 * TODO
 *
 * @author Terry
 * @since 2020/8/24 18:03
 */
public class MubiaoHe {

    int result = 0;

    public int findTargetSumWays(int[] nums, int rest) {
        if (nums.length == 0) {
            return 0;
        }
        backtrack(nums, 0,0, rest);
        return result;
    }

    public void backtrack(int[] nums, int i,int total, int rest) {
        if (nums.length == i) {
            if (total == rest) {
                result++;
            }
            return;
        }
        // 加的情况
        total += nums[i];
        backtrack(nums, i + 1,total, rest);
        rest += nums[i];
        // 减的情况
        total -= nums[i];
        backtrack(nums, i + 1,total, rest);
        rest -= nums[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int sum = 3;
        MubiaoHe mubiaoHe = new MubiaoHe();
        System.out.println(mubiaoHe.findTargetSumWays(nums, sum));
    }
}
