package leet.code.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class  MergeIntervals {
    /**
     * 209. Minimum Size Subarray Sum
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

}
