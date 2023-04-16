package leet.code.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstring {

    /**
     * Sliding Window concept.
     * Runtime: 5 ms
     * Memory Usage: 39.7 MB
     */
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int startPoint = 0;
        int end = 0;
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                startPoint = Math.max(startPoint, map.get(chars[i]) + 1);
            }
            end++;
            max = Math.max(max, end - startPoint);
            map.put(chars[i], i);
        }
        return max;
    }
    
	public static int simplerLengthOfLongestSubstring(String s) {
		int max = 1;
		Set<Character> set = new HashSet<>();
		if (s.length() == 0) {
			return 0;
		}
		set.add(s.charAt(0));
		int i = 0, j = 1;
		while (j < s.length()) {
			if (set.add(s.charAt(j))) {
				max = Math.max(max, set.size());
				j++;
			} else {
				set.remove(s.charAt(i));
				i++;
				if (i == j) {
					set.add(s.charAt(i));
					j++;
				}
			}
		}

		return max;
	}

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
