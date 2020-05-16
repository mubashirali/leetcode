package leet.code.solution;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * The solution set must not contain duplicate triplets.
 * <p>
 * Example:
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    /**
     * Runtime: 25 ms
     * Memory Usage: 43.5 MB
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right && (i == 0 || nums[i - 1] != nums[i])) {
                final int value = nums[left] + nums[right] + nums[i];
                if (value == 0) {
                    result.add(asList(nums[i], nums[left], nums[right]));
                }
                if (value > 0) {
                    int temp = right--;
                    while (nums[temp] == nums[right] && left < right) {
                        right--;
                    }
                } else {
                    int temp = left++;
                    while (nums[temp] == nums[left] && left < right) {
                        left++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{0, 0, 0}));
//        [[-2,-1,3],[-2,0,2],[-1,0,1]]
    }
}
