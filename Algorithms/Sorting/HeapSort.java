import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static void main(String args[]) {

        long start = System.nanoTime();
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = rand.nextInt(10);
        }
        System.out.println("UnSorted array:");
        printArr(arr);
        Heapsort(arr);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

        long end = System.nanoTime();
        System.out.println("Execution Time is " + (end - start) / 1000000 + " ms");
    }

    public static void Heapsort(int arr[]) {
        int n = arr.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int N, int i) {

        int max = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < N && arr[l] > arr[max])
            max = l;

        if (r < N && arr[r] > arr[max])
            max = r;

        if (max != i) {
            int swap = arr[i];
            arr[i] = arr[max];
            arr[max] = swap;

            heapify(arr, N, max);
        }
    }

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}