import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 1, 7, 12, 5, 3, 4, 6 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.t
        
    awhile (si < ei) {

        int mid = (si + ei) / 2;
            mergeSort(arr, si, mid);
            mergeSort(arr, mid + 1, ei);
            merge(arr, si, ei);
        }
    }

    private static void merge(int[] arr, int si, int ei) {
        int mid = (si + ei) / 2;
        int n1 = mid - si + 1, n2 = ei - mid;
        int l[] = new int[n1];
        int r[] = new int[n2];

        for (int i = 0; i < n1; i++) {
            l[i] = arr[si + i];
        }

        for (int i = 0; i < n2; i++) {
            r[i] = arr[mid + i + 1];
        }

        int i = 0, j = 0, k = si;

        while (i < n1 && j < n2) {
            if (l[i] <= r[j]) {
                arr[k] = l[i];
                i++;
            } else {
                arr[k] = r[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = l[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = l[j];
            j++;
            k++;
        }
            
    }
}