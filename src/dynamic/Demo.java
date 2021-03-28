package dynamic;

/**
 * 测试，01背包问题
 */
public class Demo {

    static int[] w = {0, 2, 3, 4, 5, 9};

    static int[] v = {0, 3, 4, 5, 8, 10};

    static int m = 6;

    static int n = 21;

    static int[][] dp = new int[m][n];

    private static void kanpsack() {
        // 商品重量
        for (int i = 1; i < m; i++) {
            // 背包容量
            for (int j = 1; j < n; j++) {
                //当前容纳的商品比我背包还大
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 偷
                    int value1 = dp[i - 1][j - w[i]] + v[i];
                    int value2 = dp[i - 1][j];
                    dp[i][j] = Math.max(value1, value2);
                }
            }
        }
    }

    public static void main(String[] args) {
        kanpsack();
        System.out.println(dp[5][20]);
    }
}
