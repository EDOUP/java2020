package leetcode.editor;

/**
 * <p></p>
 *
 * @author edoup
 * @date 2020/12/3 22:45
 */
public class Code204 {

    public static void main(String[] args) {

        Code204 code204 = new Code204();
        System.out.println(code204.countPrimes(10));
    }

    public int countPrimes(int n) {
        int a = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes(i)) {
                a++;
            }
        }
        return a;
    }

    public boolean isPrimes(int n) {
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


}
