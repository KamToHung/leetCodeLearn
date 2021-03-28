package sort;

import java.util.Arrays;

public class Insertion {

    private static void insertion(int[] arr, int n) {
        int key = arr[n];
        int i = n;
        while (i > 0 && arr[i - 1] > key) {
            arr[i] = arr[i - 1];
            i--;
        }
        arr[i] = key;
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            insertion(arr, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        Insertion.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
