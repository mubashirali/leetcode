package leet.code.solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.Arrays.asList;

/**
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
 * <p>
 * Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.
 * <p>
 * We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.
 * <p>
 * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed, all its children processes will be killed. No order is required for the final answer.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * pid =  [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * Output: [5,10]
 * Explanation:
 *            3
 *          /   \
 *         1     5
 *              /
 *             10
 * <p>
 * Kill 5 will also kill 10.
 */
public class KillProcess {

    public static List<Integer> solution(List<Integer> pid, List<Integer> ppid, int number) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        if (pid.contains(number)) {
            queue.add(number);
        }

        while (!queue.isEmpty()) {
            final Integer poll = queue.poll();
            result.add(poll);

            int index = ppid.indexOf(poll);
            if (index >= 0) {
                queue.add(pid.get(index));
            }
        }


        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(asList(1, 3, 10, 5), asList(3, 0, 5, 3), 5));
    }
}
