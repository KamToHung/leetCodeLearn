package dynamic;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 * 思路：
 * 当i>0和j>0，f[i][j] = min(f[i-1][j]+grid[i][j],f[i][j-1]+grid[i][j])
 * 当i=0&&j>0时，一行数据最短路径可以确定，f[0][j] = f[0][j-1] + grid[0][j]
 * 当j=0&&i>0时，一列数据最短路径可以确定，f[i][0] = f[i-1][0] + grid[i][0];
 * 出口：
 * f[0][0] = grid[0][0];
 */
public class Leetcode64 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j > 0) {
                    dp[i][j] = dp[0][j - 1] + grid[i][j];
                } else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i - 1][0] + grid[i][j];
                } else if (i > 0 && j > 0) {
                    int value1 = dp[i - 1][j] + grid[i][j];
                    int value2 = dp[i][j - 1] + grid[i][j];
                    dp[i][j] = Math.min(value1, value2);
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}