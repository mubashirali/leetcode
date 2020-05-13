package leet.code.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 * <p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * <p>
 * Example 1:
 * <p>
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * <p>
 * Example 3:
 * <p>
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * <p>
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters that may be separated by a single space.
 */
public class WordPattern {

    /**
     * Runtime: 0 ms
     * Memory Usage: 37.2 MB
     */
    public static boolean wordPattern(String pattern, String str) {
        final String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) {
            return false;
        }

        Map<String, Character> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            Character result = map.get(strArray[i]);
            if (result == null && map.containsValue(pattern.charAt(i))) {
                return false;
            }
            if (result != null && pattern.charAt(i) != result) {
                return false;
            }
            map.put(strArray[i], pattern.charAt(i));
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));
    }
}
