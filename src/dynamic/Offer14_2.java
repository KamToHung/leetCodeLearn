package dynamic;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
 * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * 和Offer14区别是不能用动态规划了
 */
public class Offer14_2 {

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n = n - 3;
        }
        return (int) (res * n % 1000000007);
    }

    public static void main(String[] args) {
        Offer14_2 offer14_2 = new Offer14_2();
        System.out.println(offer14_2.cuttingRope(10));
    }
}
