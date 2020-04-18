package leet.code.solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KMaxOrMinNumbersFromList {

    private static void minNumbers(int k, int[] array) {
        Queue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());

        for (int number : array) {
            if (queue.isEmpty()) {
                queue.add(number);
            } else if (queue.size() < k || queue.peek() > number) {
                if (queue.size() == k) {
                    queue.poll();
                }
                queue.add(number);
            }
        }
        queue.forEach(System.out::println);

    }

    private static void maxNumbers(int k, int[] array) {
        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int number : array) {
            if (queue.isEmpty()) {
                queue.add(number);
            } else if (queue.size() < k || queue.peek() < number) {
                if (queue.size() == k) {
                    queue.remove();
                }
                queue.add(number);
            }
        }
        queue.forEach(System.out::println);

    }

    private static void minNumbersWithArray(int k, int[] array) {
        Arrays.sort(array);
        int[] newArray = new int[k];

        for (int i = 0; i < k; i++) {
            newArray[i] = array[i];
        }
       Arrays.stream(newArray).forEach(System.out::println);

    }

    public static void main(String[] args) {
        String a = "a1 asdf";

        Arrays.stream(a.split(" ", 4)).forEach(System.out::println);

//
//        minNumbers(5, new int[]{1, 23, 5, 4, 2, 85, 23, 43, 67, 65, 44});
//        System.out.println();
//        maxNumbers(6, new int[]{1, 23, 5, 4, 2, 85, 23, 43, 67, 65, 44});
//        System.out.println();
//        minNumbersWithArray(6, new int[]{1, 23, 5, 4, 2, 85, 23, 43, 67, 65, 44});
    }
}
