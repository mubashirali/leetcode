package leet.code.solution;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <p>
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * <p>
 * Note that an empty string is also considered valid.
 * <p>
 * Example 1:
 * <p>
 * Input: "()"
 * Output: true
 * <p>
 * Example 2:
 * <p>
 * Input: "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * <p>
 * Input: "(]"
 * Output: false
 * <p>
 * Example 4:
 * <p>
 * Input: "([)]"
 * Output: false
 * <p>
 * Example 5:
 * <p>
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {

    /**
     * Runtime: 1 ms
     * Memory Usage: 37.1 MB
     */
    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('(', ')');
        pairs.put('{', '}');
        pairs.put('[', ']');

        for (char c : s.toCharArray()) {
            if (pairs.containsKey(c)) {
                stack.add(c);
            } else if (stack.isEmpty() || c != pairs.get(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }
}
