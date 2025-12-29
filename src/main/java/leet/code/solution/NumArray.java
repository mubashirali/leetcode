
package leet.code.solution;

import java.util.*;


/**
 * 303. Range Sum Query - Immutable
 * https://leetcode.com/problems/range-sum-query-immutable/description/?envType=problem-list-v2&envId=array
 * Given an integer array nums, handle multiple queries of the following type:
 *
 *     Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
 *
 * Implement the NumArray class:
 *
 *     NumArray(int[] nums) Initializes the object with the integer array nums.
 *     int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1, -1, -3]
 *
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 */
public class NumArray {
    public static void main(String[] args) {

        System.out.println(Arrays.stream(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2,3,1,5,1})));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(Arrays.stream(nums1).boxed().toList());
        Set<Integer> set2 = new HashSet<>(Arrays.stream(nums2).boxed().toList());

        set.retainAll(set2);
        System.out.println(set);
        return set.stream().mapToInt(i -> i).toArray();
    }

}

