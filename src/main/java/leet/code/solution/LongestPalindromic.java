package leet.code.solution;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromic {

    public static String longestPalindromeCorrect(String s) {
        String pal = "";
        for (int k = 0; k < s.length(); k++) {
            int j = s.length() - 1;
            while (k <= j) {
                if (s.charAt(k) == s.charAt(j)) {
                    String substring = s.substring(k, j + 1);
                    if (isPalindromeCorrect(substring)) {
                        if (pal.length() < substring.length()) {
                            pal = substring;
                        }
                    }
                }
                j--;
            }
        }
        return pal;
    }

    private static boolean isPalindromeCorrect(String substring) {
        StringBuilder sb = new StringBuilder(substring);

        return substring.contentEquals(sb.reverse());
    }
    
    /**
     *
     * Works but time time Limit Exceeded issue for string really big string
     */
    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 1;
        if (isPalindrome(s.substring(0, s.length()))) {
            return (s.substring(0, s.length()));
        }
        for (int i = 2; i < s.length(); i++) {
            int window = i;
            for (int j = 0; window < s.length(); j++) {
                window = i + j;
                if (isPalindrome(s.substring(j, window))) {
                    if (s.substring(j, window).length() > s.substring(start, end).length()) {
                        start = j;
                        end = window;
                    }
                }
            }
        }
        return s.substring(start, end);
    }

    public static boolean isPalindrome(String str) {
        String copy = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            copy += str.charAt(i);
        }
        return str.equals(copy);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

}
