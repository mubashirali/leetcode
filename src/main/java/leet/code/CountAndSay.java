package leet.code;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 38. Count and Say
 * Solved
 * Medium
 * Topics
 * premium lock iconCompanies
 * Hint
 * <p>
 * The count-and-say sequence is a sequence of digit strings defined by the recursive formula:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) is the run-length encoding of countAndSay(n - 1).
 * <p>
 * Run-length encoding (RLE) is a string compression method that works by replacing consecutive identical characters (repeated 2 or more times) with the concatenation of the character and the number marking the count of the characters (length of the run). For example, to compress the string "3322251" we replace "33" with "23", replace "222" with "32", replace "5" with "15" and replace "1" with "11". Thus the compressed string becomes "23321511".
 * <p>
 * Given a positive integer n, return the nth element of the count-and-say sequence.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4
 * <p>
 * Output: "1211"
 * <p>
 * Explanation:
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(2) = RLE of "1" = "11"
 * countAndSay(3) = RLE of "11" = "21"
 * countAndSay(4) = RLE of "21" = "1211"
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * <p>
 * Output: "1"
 * <p>
 * Explanation:
 * <p>
 * This is the base case.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 30
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(6));
    }

    public static String countAndSay(int n) {
        String ans = "1";

        for (int i = 0; i < n - 1; i++) {
            char[] charArray = ans.toCharArray();
            ans = andCount(charArray);
        }


        return ans;
    }

    private static String andCount(char[] charArray) {
        String andSay = "";
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : charArray) {
            if (map.containsKey(c)) {
                int val = map.get(c);
                map.put(c, ++val);
            } else {
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    andSay += entry.getValue() + "" + entry.getKey();
                }
                map.clear();
                map.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            andSay += entry.getValue() + "" + entry.getKey();
        }

        return andSay;
    }

}

