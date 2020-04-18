package leet.code.solution;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * <p>
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class MedianOfTwoArrays {

    /**
     * Runtime: 2 ms
     * Memory Usage: 40.7 MB
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l = 0;
        int r = 0;
        int arr[] = new int[nums1.length + nums2.length];
        int index = 0;
        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] <= nums2[r]) {
                arr[index] = nums1[l];
                l++;
            } else if (nums2[r] <= nums1[l]) {
                arr[index] = nums2[r];
                r++;
            }
            index++;
        }
        while (l < nums1.length || r < nums2.length) {
            if (l < nums1.length) {
                arr[index] = nums1[l];
                l++;

            } else {
                arr[index] = nums2[r];
                r++;
            }
            index++;
        }
        if (arr.length % 2 == 0) {
            return (double) (arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2;
        } else {
            return (double) arr[arr.length / 2] / 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }
}
