package dfs;

/**
 * 在二维网格 grid 上，有 4 种类型的方格：
 * <p>
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * <p>
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 * <p>
 * 示例 1：
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),
 * 示例 2：
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * 输出：4
 * 解释：我们有以下四条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),
 * 示例 3：
 * 输入：[[0,1],[2,0]]
 * 输出：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 * 思路：
 * 先找出所有空格，如果遇到2后空格时候和行走的路径相同，是的话保存，否则回溯
 */
public class Leetcode980 {

    private int result = 0;

    public int uniquePathsIII(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        // 找出初始开始节点
        int x = 0;
        int y = 0;
        boolean[][] memo = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                } else if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                    count++;
                }
            }
        }
        dfs(grid, memo, x, y, count, 0);
        return result;
    }

    /**
     * @param grid  表格
     * @param memo  记录表
     * @param x     列
     * @param y     行
     * @param count 空白格数量
     * @param sum   路过的空白格数量+开始格子
     */
    private void dfs(int[][] grid, boolean[][] memo, int x, int y, int count, int sum) {
        // 这种情况就返回
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == -1 || memo[x][y]) {
            return;
        }
        // 和空白格+开始格子数量相等，则保存
        if (grid[x][y] == 2 && sum == count) {
            result++;
            return;
        }
        memo[x][y] = true;
        dfs(grid, memo, x - 1, y, count, sum + 1);
        dfs(grid, memo, x + 1, y, count, sum + 1);
        dfs(grid, memo, x, y - 1, count, sum + 1);
        dfs(grid, memo, x, y + 1, count, sum + 1);
        memo[x][y] = false;
    }
}
