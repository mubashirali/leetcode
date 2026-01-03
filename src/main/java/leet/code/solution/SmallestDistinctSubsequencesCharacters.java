package leet.code.solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SmallestDistinctSubsequencesCharacters {
    /**
     * Given a string s, return the
     *
     * of s that contains all the distinct characters of s exactly once.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "bcabc"
     * Output: "abc"
     *
     * Example 2:
     *
     * Input: s = "cbacdcbc"
     * Output: "acdb"
     *
     *
     *
     * Constraints:
     *
     *     1 <= s.length <= 1000
     *     s consists of lowercase English letters.
     *
     *
     * Note: This question is the same as 316: https://leetcode.com/problems/remove-duplicate-letters/
     *
     *
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(removeDuplicateLetters("bcabc"));
    }

    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> last = new HashMap<>();
        Set<Character> seen = new HashSet<>();

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            last.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            if (seen.contains(s.charAt(i))) {
                continue;
            }
            while (!stack.empty() && stack.peek() > s.charAt(i) && (last.get(stack.peek()) > i)) {
                Character pop = stack.pop();
                seen.remove(pop);
                result = result.replace(String.valueOf(pop), "");
            }
            stack.push(s.charAt(i));
            seen.add(s.charAt(i));
            result += String.valueOf(s.charAt(i));
        }
        return result;
    }
}

