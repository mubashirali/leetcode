package leet.code.solution;

/**
 * Given a palindromic string palindrome, replace exactly one character by any lowercase English letter so that the
 * string becomes the lexicographically smallest possible string that isn't a palindrome.
 * <p>
 * After doing so, return the final string.  If there is no way to do so, return the empty string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: palindrome = "abccba"
 * Output: "aaccba"
 * <p>
 * Example 2:
 * <p>
 * Input: palindrome = "a"
 * Output: ""
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= palindrome.length <= 1000
 * palindrome consists of only lowercase English letters.
 */
public class BreakPalindrome {

    public static void main(String[] args) {
        System.out.println(breakPalindrome("aba"));
    }

    /**
     * Runtime: 0 ms
     * Memory Usage: 37.6 MB
     */
    public static String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }
        char[] charArray = palindrome.toCharArray();
        for (int i = 0; i < palindrome.length(); i++) {
            if (i == palindrome.length() / 2) {
                continue;
            }
            if (charArray[i] != 'a') {
                charArray[i] = 'a';
                return String.valueOf(charArray);
            }
        }
        return palindrome.substring(0, palindrome.length() - 1) + 'b';

    }
}
