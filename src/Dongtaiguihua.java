/**
 * 斐波那契数列
 * @author Terry
 * @since 2020/8/12 11:36
 */
public class Dongtaiguihua {

    public static int fib(int n) {
        if (n < 1) {
            return 0;
        }
        //作为缓存
        int[] memo = new int[n + 1];
        return fib(memo, n);
    }

    public static int fib(int[] memo, int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo[n] != 0) {
            return memo[n];
        }
        memo[n] = fib(memo, n - 1) + fib(memo, n - 2);
        return memo[n];
    }

    public static int fibNew(int N) {
        if (N == 1 || N == 2)
            return 1;
        return fibNew(N - 1) + fibNew(N - 2);
    }

    public static int fibLatest(int N) {
        int[] dp = new int[N + 1];
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }

    public static int fibEasy(int N) {
        if (N == 2 || N == 1) {
            return 1;
        }
        int prev = 1;
        int curr = 1;
        for (int i = 3; i <= N; i++) {
            int sum = prev + curr;
            prev = curr;
            curr = sum;
        }
        return curr;
    }

    public static void main(String[] args) {
        int n = 60;
//        System.out.println(fib(n));
        System.out.println(fibEasy(20));

    }
}
