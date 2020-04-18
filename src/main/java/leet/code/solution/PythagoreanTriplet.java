package leet.code.solution;

import java.util.HashSet;
import java.util.Set;

public class PythagoreanTriplet {

    private static boolean triplets(int[] array) {
        Set<Long> set = new HashSet<>();

        for (int number : array) {
            set.add((long) (number * number));
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (set.contains((long) (array[i] * array[i]) + (array[j] * array[j]))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(triplets(new int []{10, 3, 13, 12, 5}));
    }
}
