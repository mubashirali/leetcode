package leet.code.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 989. Add to Array-Form of Integer
 * Solved
 * Easy
 * Topics
 * premium lock iconCompanies
 *
 * The array-form of an integer num is an array representing its digits in left to right order.
 *
 *     For example, for num = 1321, the array form is [1,3,2,1].
 *
 * Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.
 *
 *
 *
 * Example 1:
 *
 * Input: num = [1,2,0,0], k = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 *
 * Example 2:
 *
 * Input: num = [2,7,4], k = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 *
 * Example 3:
 *
 * Input: num = [2,1,5], k = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 *
 *
 *
 * Constraints:
 *
 *     1 <= num.length <= 104
 *     0 <= num[i] <= 9
 *     num does not contain any leading zeros except for the zero itself.
 *     1 <= k <= 104
 */
public class AddToArrayFormOfInteger {

    public static void main(String[] args) {
        System.out.println(addToArrayForm(new int[]{7}, 993));

    }

public List<Integer> addToArrayFormBigInt(int[] num, int k) {
        StringBuilder str = new StringBuilder();
        for(int i=0; i<num.length; i++){
            str.append(num[i]);
        }
        List<Integer> list = new ArrayList<>();
        BigInteger big = new BigInteger(str.toString()).add(BigInteger.valueOf(k));
        String newStr =big.toString();
        for(int i=0; i<newStr.length(); i++){
            list.add(newStr.charAt(i) - '0');
        }

        return list;
    }
  
    public static List<Integer> addToArrayForm(int[] num, int k) {
        String s = String.valueOf(k);
        int maxSize = Math.max(s.length(), num.length) + 1;
        Integer[] list = new Integer[maxSize];
        Arrays.fill(list, 0);
        for (int i = s.length() - 1, j = list.length - 1; i >= 0; i--, j--) {
            list[j] = s.charAt(i) - '0';
        }
        for (int i = num.length - 1, j = list.length - 1; j >= 0; i--, j--) {
            int temp = list[j];
            if (i >= 0) {
                temp += num[i];
            }
            if (j >= 1) {
                list[j - 1] += (temp / 10);
            }
            list[j] = temp % 10;
        }
        List<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.length; i++) {
            if (i == 0 && list[0] == 0) {
                continue;
            }
            newList.add(list[i]);
        }

        return newList;
    }

}
