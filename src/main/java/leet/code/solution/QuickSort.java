package leet.code.solution;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        quickSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            final int pivot = partition(arr, low, high);
            quickSort(arr, low, pivot);
            quickSort(arr, pivot + 1, high);

        }
    }

    private static int partition(int[] arr, int low, int high) {
        int start = low;
        int end = high;
        while (start < end) {
            while (arr[start] <  arr[low]) {
                start++;
            }

            while (arr[end] > arr[low]) {
                end--;
            }

            if (start < end) {
                swap(arr, start, end);
            }
        }
        swap(arr, start, end);

        return end;
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
