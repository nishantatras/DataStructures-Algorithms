import java.util.Arrays;

public class SearchingProblems {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 7, 5, 6, 2 };

        System.out.println(missingNumber(arr, arr.length));
        System.out.println(arr[ceiling(arr, 4, arr.length)]);

    }

    // Missing Number from List of Natural numbers with no duplicates
    public static int missingNumber(int[] arr, int n) {
        // BruteForce 0(nlogn)
        Arrays.sort(arr);
        int i = 0;
        while (i < n - 1) {
            if (arr[i] != arr[i + 1] - 1) {
                return (arr[i] + arr[i + 1]) / 2;
            }
            i++;
        }

        // Hashing 0(n)
        int num[] = new int[n + 1];
        for (int j = 0; j < n; j++) {
            num[arr[j] - 1]++;
        }

        for (int j = 0; j <= n; j++) {
            if (num[j] == 0) {
                return j + 1;
            }
        }

        return -1;
    }

    public static int ceiling(int[] arr, int x, int n) {
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                l = mid + 1;
                ;
            } else {
                r = mid - 1;
            }

        }
        return l;
    }

    public static int floor(int[] arr, int x, int n) {
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] < x) {
                l = mid + 1;
                ;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}