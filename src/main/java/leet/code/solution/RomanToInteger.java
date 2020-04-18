package leet.code.solution;

import java.util.*;

/**
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 *     I can be placed before V (5) and X (10) to make 4 and 9.
 *     X can be placed before L (50) and C (100) to make 40 and 90.
 *     C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 *
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 *
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 *
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 *
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 *
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomanToInteger {

    /**
     * Runtime: 11 ms
     * Memory Usage: 40.7 MB
     */
    private static int romanToInt(String s) {
        Map<Character, Integer> romanChar = new HashMap<>();
        Map<String, Integer> edgeCases = new HashMap<>();
        edgeCases.put("IV", 4);
        edgeCases.put("IX", 9);
        edgeCases.put("XL", 40);
        edgeCases.put("XC", 90);
        edgeCases.put("CD", 400);
        edgeCases.put("CM", 900);

        romanChar.put('I', 1);
        romanChar.put('V', 5);
        romanChar.put('X', 10);
        romanChar.put('L', 50);
        romanChar.put('C', 100);
        romanChar.put('D', 500);
        romanChar.put('M', 1000);

        int number = 0;

        int i = 0;
        while (i < s.length()) {
            int temp = romanChar.get(s.charAt(i));
            if (i < s.length() - 1 && edgeCases.containsKey(s.charAt(i) + "" + s.charAt(i + 1))) {
                temp = edgeCases.get(s.charAt(i) + "" + s.charAt(i + 1));
                i++;
            }
            i++;
            number += temp;
        }
        return number;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
