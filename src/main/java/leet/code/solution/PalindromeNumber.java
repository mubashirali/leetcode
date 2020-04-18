package leet.code.solution;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */
public class PalindromeNumber {
    /**
     * Runtime: 9 ms
     * Memory Usage: 39 MB
     */
    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        return new StringBuilder().append(x).reverse().toString().equals(String.valueOf(x));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1));
    }
}
