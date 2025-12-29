package leet.code.solution;

import java.util.*;

/**
 * https://leetcode.com/problems/intersection-of-two-arrays/description/
 * 349. Intersection of Two Arrays
 * Given two integer arrays nums1 and nums2, return an array of their
 *
 * . Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 */
public class Intersection {
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

