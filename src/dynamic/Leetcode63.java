package dynamic;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Fi
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * 示例 1：
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * 示例 2：
 * <p>
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * 思路：
 * 确定状态转移方程式：
 * d[i][j] = dp[i-1][j] + dp[i][j-1]
 * 出口：
 * d[0][j] = 1;
 * d[i][0] = 1;
 * 遇到障碍物跳过，并且如果是出口上则出口后的点都为0
 */
public class Leetcode63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        int flag = 1;
        for (int i = 0; i < m; i++) {
            // 如果为1则后面位置都为0
            if (obstacleGrid[i][0] == 1) {
                flag = 0;
            }
            dp[i][0] = flag;
        }
        flag = 1;
        for (int i = 0; i < n; i++) {
            // 如果为1则后面位置都为0
            if (obstacleGrid[0][i] == 1) {
                flag = 0;
            }
            dp[0][i] = flag;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
