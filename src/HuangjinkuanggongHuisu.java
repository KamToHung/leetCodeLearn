/**
 * 1219
 *
 * @author Terry
 * @since 2020/8/25 17:39
 */
public class
HuangjinkuanggongHuisu {

    private int max = 0;

    public int getMaximumGold(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visitor = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    backtrack(grid, visitor, i, j, 0);
                }
            }
        }
        return max;
    }

    void backtrack(int[][] grid, boolean[][] visitor, int x, int y, int totalNum) {
        if ((x < 0 || x >= grid.length) || (y < 0 || y > grid[0].length) ||
                grid[x][y] == 0 || visitor[x][y]) {
            max = Math.max(max, totalNum);
            return;
        }
        totalNum += grid[x][y];
        visitor[x][y] = true;
        backtrack(grid, visitor, x + 1, y, totalNum);
        backtrack(grid, visitor, x - 1, y, totalNum);
        backtrack(grid, visitor, x, y + 1, totalNum);
        backtrack(grid, visitor, x, y - 1, totalNum);
        visitor[x][y] = false;
        totalNum -= grid[x][y];
    }

    public static void main(String[] args) {
        int[][] grid = new int[3][4];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                grid[i][j] = 1;
            }
        }
        System.out.println(1);
    }
}
