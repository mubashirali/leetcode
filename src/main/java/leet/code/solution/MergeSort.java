package leet.code.solution;

public class MergeSort {

    public static void sort(int[] arr, int left, int right, int mid) {
        int j = mid + 1;
        int i = left;
        int[] temp = new int[(right - left) + 1];
        int index = 0;
        while (i <= mid && j <= right) {
            if (arr[i] < arr[j]) {
                temp[index] = arr[i];
                i++;
            } else {
                temp[index] = arr[j];
                j++;
            }
            index++;
        }
        while (i <= mid) {
            temp[index++] = arr[i++];
        }
        while (j <= right) {
            temp[index++] = arr[j++];
        }

        for (int tmp: temp) {
            arr[left] = tmp;
            left++;
        }
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);

        sort(arr, left, right, mid);

    }

    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
