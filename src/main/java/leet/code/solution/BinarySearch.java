package leet.code.solution;

public class BinarySearch {

    private static void search(int[] list, int number) {
        int left = 0;
        int right = list.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (list[mid] == number) {
                System.out.println("Found number " + list[mid]);
                return;
            }
            if (list[mid] > number) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println("Number not found!");

    }

    public static void main(String[] args) {
        search(new int[]{1, 2, 3, 4, 5, 6, 9, 76}, 76);
    }
}
