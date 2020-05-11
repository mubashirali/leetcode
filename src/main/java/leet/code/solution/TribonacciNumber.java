package leet.code.solution;

public class TribonacciNumber {

    /**
     * Runtime: 0 ms
     * Memory Usage: 35.9 MB
     */
    public static int tribonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        int ans = 1;
        int[] temp = {0, 1, 1};

        for (int i = 2; i < n; i++) {
            ans = temp[0] + temp[1] + temp[2];
            temp[0] = temp[1];
            temp[1] = temp[2];
            temp[2] = ans;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }
}
