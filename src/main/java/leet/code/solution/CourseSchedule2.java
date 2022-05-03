package leet.code.solution;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * <p>
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 */


public class CourseSchedule2 {
  

    /**
     * https://youtu.be/mB3PGwnpM1k
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
     Map<Integer, List<Integer>> neighbours = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[numCourses];
        List<Integer> order = new ArrayList<>();

        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            List<Integer> list = neighbours.getOrDefault(prerequisite[1], new ArrayList<>());
            list.add(prerequisite[0]);
            neighbours.put(prerequisite[1], list);
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                order.add(i);
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            List<Integer> list = neighbours.get(poll);
            for (int i = 0; list != null && i < list.size(); i++) {
                inDegree[list.get(i)]--;
                if (inDegree[list.get(i)] == 0) {
                    queue.add(list.get(i));
                    order.add(list.get(i));
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] != 0) {
                return new int[]{};
            }
        }

        return order.stream().mapToInt(i -> i).toArray();
    }
}
