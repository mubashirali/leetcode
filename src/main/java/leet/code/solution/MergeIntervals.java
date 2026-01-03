package leet.code.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class  MergeIntervals {
    /**
     * 56. Merge Intervals
     * Solved
     * Medium
     * Topics
     * premium lock iconCompanies
     *
     * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
     *
     *
     *
     * Example 1:
     *
     * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
     * Output: [[1,6],[8,10],[15,18]]
     * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
     *
     * Example 2:
     *
     * Input: intervals = [[1,4],[4,5]]
     * Output: [[1,5]]
     * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
     *
     * Example 3:
     *
     * Input: intervals = [[4,7],[1,4]]
     * Output: [[1,7]]
     * Explanation: Intervals [1,4] and [4,7] are considered overlapping.
     *
     * @param args
     */
    public static void main(String[] args) {

//        nextGreaterElements(new int[][]{{4, 7}, {1, 4}});
//        nextGreaterElements(new int[][]{{1, 4}, {4, 5}});
//        nextGreaterElements(new int[][]{{1, 4}, {2, 3}});
        merge(new int[][]{{1, 4}, {0,2}, {3,5}});
//        nextGreaterElements(new int[][]{{1,3}, {2,6}, {8,10},{15,18}});

    }

    public static int[][] merge(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.addAll(Arrays.asList(intervals));
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int i = 0;
        int prev = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            ArrayList<Integer> temp = new ArrayList<>();
            if (i > 0 && prev >= poll[0]) {
                ArrayList<Integer> prevList = list.get(i - 1);
                prev = Math.max(prev, poll[1]);
                prevList.remove(1);
                prevList.add(prev);
                continue;
            }
            temp.add(poll[0]);
            temp.add(poll[1]);
            prev = poll[1];
            list.add(temp);
            i++;
        }
        System.out.println(list);

        int[][] result = new int[list.size()][2];
        i = 0;
        for (ArrayList<Integer> ints : list) {
            result[i][0] = ints.get(0);
            result[i][1] = ints.get(1);
            i++;
        }
        return result;
    }

    public int[][] mergeSimpler(int[][] intervals) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        queue.addAll(Arrays.asList(intervals));
        ArrayList<int[]> list = new ArrayList<>();
        int i = 0;
        int prev = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (i > 0 && prev >= poll[0]) {
                int[] prevList = list.get(i - 1);
                prev = Math.max(prev, poll[1]);
                prevList[1] = prev;
                continue;
            }
            int [] temp =  new int[2];
            temp[0] = poll[0];
            temp[1] = poll[1];
            prev = poll[1];
            list.add(temp);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }

}
