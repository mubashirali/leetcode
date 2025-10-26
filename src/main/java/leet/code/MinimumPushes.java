package leet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 35. Search Insert Position
 * Solved
 * Easy
 * Topics
 * premium lock iconCompanies
 * <p>
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * <p>
 * Example 3:
 * <p>
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * https://leetcode.com/problems/search-insert-position/description/
 */
public class MinimumPushes {
    public static void main(String[] args) {
        System.out.println(minimumPushes("abcde"));
    }

    public static int minimumPushes(String word) {
        int count = 0;

        int i = 0;
        int max = 7;
        Map<Integer, List<Character>> map = new HashMap<>();

        for (char c : word.toCharArray()) {
            List<Character> list = map.getOrDefault(i, new ArrayList<>());
            list.add(c);
            map.put(i, list);
            if (i < max) {
                i++;
            } else {
                i = 0;
            }

        }

        for (Map.Entry<Integer, List<Character>> entry : map.entrySet()) {
            List<Character> characters = entry.getValue();
            count += IntStream.rangeClosed(1, characters.size()).sum();
        }

        return count;
    }
}

