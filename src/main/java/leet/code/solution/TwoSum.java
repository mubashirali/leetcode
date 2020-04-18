package leet.code.solution;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1]
 */
public class TwoSum {

    /**
     * Runtime: 2 ms
     * Memory Usage: 39.3 MB
     */
    public static int[] optimised(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> valueIndex = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int tempValue = target - nums[i];

            if (valueIndex.containsKey(tempValue)) {
                result[0] = valueIndex.get(tempValue);
                result[1] = i;
            }
            valueIndex.put(nums[i], i);
        }
        return result;
    }

    public static int[] bruteForce(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }


}
