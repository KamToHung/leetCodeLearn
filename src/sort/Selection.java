package sort;

import java.util.Arrays;

public class Selection {


    private static int findIndex(int[] arr, int n) {
        int max = arr[0];
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    private static void selectionSort(int[] arr) {
        for (int i = arr.length; i >= 1; i--) {
            int index = findIndex(arr,i);
            int temp = arr[index];
            arr[index] = arr[i -1];
            arr[i-1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        Selection.selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
