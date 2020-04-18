package leet.code.solution;

import java.util.*;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * <p>
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * <p>
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {
    public static int reverse(int x) {

        Queue s = new LinkedList();

        String number = String.valueOf(x);
        String result = "";
        int size = 0;
        if (number.contains("-")) {
            ++size;
            result += "-";
        }
        for (int i = number.length() - 1; i >= size; i--) {
            result += String.valueOf(number.charAt(i));
        }

        try {
            return Integer.parseInt(result);
        } catch (Exception e) {
            return 0;
        }
    }
}
