import java.util.Arrays;
import java.util.Random;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            arr[i] = rand.nextInt(10);
        }
        System.out.println("UnSorted array:");
        printArr(arr);
        BubbleSort(arr, arr.length);
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void BubbleSort(int[] arr, int n) {

        for (int i = 0; i < n; i++) {
            boolean swap = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap = true;
                }
            }
            if (!swap) {
                break;
                
            }
        }
    }
}