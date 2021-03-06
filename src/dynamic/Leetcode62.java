package dynamic;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为
 * 问总共有多少条不同的路径？
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * 思路：
 * 确定状态转移方程式：
 * d[i][j] = dp[i-1][j] + dp[i][j-1]
 * 出口：
 * d[0][j] = 1;
 * d[i][0] = 1;
 */
public class Leetcode62 {

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

//    class Solution {
//        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//            int m = obstacleGrid.length, n = obstacleGrid[0].length;
//            int[][] dp = new int[m][n];
//            for(int i = 0; i < m; i++) {
//                for(int j = 0; j < n; j++) {
//                    //遇到障碍物，dp[i][j] = 0
//                    if(obstacleGrid[i][j] == 1)
//                        continue;
//                    if(i == 0 && j == 0) {
//                        dp[i][j] = 1;
//                    } else if(i == 0) {
//                        dp[i][j] = dp[i][j-1];
//                    } else if(j == 0) {
//                        dp[i][j] = dp[i-1][j];
//                    } else {
//                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
//                    }
//                }
//            }
//            return dp[m-1][n-1];
//        }
//    }
}
