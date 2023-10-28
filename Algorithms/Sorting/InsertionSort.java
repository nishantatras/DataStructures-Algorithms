import java.util.Arrays;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        long start = System.nanoTime();

        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = rand.nextInt(10);
        }
        System.out.println("UnSorted array:");
        printArr(arr);
        InsertionSort(arr, arr.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

        long end = System.nanoTime();
        System.out.println("Execution Time is " + (end - start) / 1000000 + " ms");
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void InsertionSort(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}