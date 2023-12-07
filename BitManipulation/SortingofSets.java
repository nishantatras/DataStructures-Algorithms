import java.util.Arrays;

public class SortingofSets {

    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[] bit = new int[n];
        for (int i = 0; i < n; i++) {
            bit[i] = count(arr[i]);
        }
        sort(arr, bit, 0, n - 1);
        return arr;
    }

    public int count(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public void sort(int[] arr, int[] bit, int l, int r) {
        while (l < r) {
            int mid = (l + r) / 2;
            sort(arr, bit, l, mid);
            sort(arr, bit, mid + 1, r);
            merge(arr, bit, l, mid, r);
        }
    }

    public void merge(int[] arr, int[] bit, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = bit[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = bit[m + 1 + j];

        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        SortingofSets s = new SortingofSets();
        int arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
        s.sortByBits(arr);
        System.out.println(Arrays.toString(arr));

    }
}