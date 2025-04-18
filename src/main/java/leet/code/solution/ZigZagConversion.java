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

    public static String convert2(String s, int numRows) {
        StringBuilder result = new StringBuilder();
        char[][] arr = new char[numRows][s.length()];
        int k = 0;
        int col = 0;
        boolean decs;
        boolean ceiling = true;

        for (int i = 0; i < s.length(); i++) {
            if (numRows <= 1) {
                return s;
            }
            if (k < numRows - 1 && ceiling) {
                decs = false;
            } else {
                decs = true;
                ceiling = false;
            }
            if (!decs) {
                arr[k][col] = s.charAt(i);
                k++;
            } else {
                arr[k][col] = s.charAt(i);
                k--;
                col++;
            }

            if (k == 0) {
                ceiling = true;
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (arr[i][j] != '\0')
                    result.append(arr[i][j]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("Apalindromeisaword,phrase,number,orothersequenceofunitsthatcanbereadthesamewayineitherdirection,withgeneralallowancesforadjustmentstopunctuationandworddividers.",
                1));
    }
}
