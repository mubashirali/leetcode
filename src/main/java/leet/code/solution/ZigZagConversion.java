package leet.code.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime: 12 ms
 * Memory Usage: 40.6 MB
 */
public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        Map<Integer, String> result = new HashMap<>();

        boolean decrement = false;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index == 0) {
                decrement = false;
            } else if (index == numRows - 1) {
                decrement = true;
            }

            String temp = result.getOrDefault(index, "");
            temp += String.valueOf(s.charAt(i));
            result.put(index, temp);
            if (decrement) {
                index--;
            } else {
                index++;
            }

        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String str : result.values()) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",
                1));
    }
}
