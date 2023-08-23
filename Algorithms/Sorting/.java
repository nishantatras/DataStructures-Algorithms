import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        // int[] arr = new int[10];
        int[] arr = { 1, 7, 5, 6, 2 };
        // Random rand = new Random();
        // for (int i = 0; i < 10; i++) {
        // arr[i] = rand.nextInt(10);
        // }
        System.out.println("UnSorted array:");
        printArr(arr);
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int si, int ei) {
        if (si < ei) {
            int pi = partition1(arr, si, ei);
            quickSort(arr, si, pi - 1);
            quickSort(arr, pi + 1, ei);
        }

    }

    // Choosing 1st element as pivot
    private static int partition1(int[] arr, int si, int ei) {
        int pivot = arr[si];
        int i = si;
        for (int j = si + 1; j <= ei; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i, si);
        return i;
    }

    // Choosing last element as pivot
    private static int partition2(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = -1;
        for (int j = 0; j <= ei - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, ei);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}