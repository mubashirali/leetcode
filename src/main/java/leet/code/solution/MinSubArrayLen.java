package leet.code.solution;

public class MinSubArrayLen {
    /**
     * 209. Minimum Size Subarray Sum
     * Given an array of positive integers nums and a positive integer target, return the minimal length of a
     *
     * whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
     *
     *
     *
     * Example 1:
     *
     * Input: target = 7, nums = [2,3,1,2,4,3]
     * Output: 2
     * Explanation: The subarray [4,3] has the minimal length under the problem constraint.
     *
     * Example 2:
     *
     * Input: target = 4, nums = [1,4,4]
     * Output: 1
     *
     * Example 3:
     *
     * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
     * Output: 0
     *
     *
     *
     * Constraints:
     *
     *     1 <= target <= 109
     *     1 <= nums.length <= 105
     *     1 <= nums[i] <= 104
     *
     *
     * Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
     */
    public static void main(String[] args) {

        System.out.println(minSubArrayLen(213, new int[]{12,28,83,4,25,26,25,2,25,25,25,12}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0, windowSize = Integer.MAX_VALUE;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= target) {
                windowSize = Math.min(windowSize, (j - i) + 1);
                sum -= nums[i++];
            }
        }

        return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
    }

}

