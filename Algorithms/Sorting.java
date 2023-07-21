package Algorithms;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        // Using Radnom Class to Create Random Array
        Random r = new Random();
        int arr[] = new int[10];

        // Initialising Array with random numbers
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10);
        }

        // Using Radnom Class to Create Random Var to Search
        int x = r.nextInt(10);

        // // Linear Search
        // System.out.println(x + " is present at " + LinearSearch(arr, x) + " index in
        // the array" + Arrays.toString(arr));

        // Sorting Array
        Arrays.sort(arr);

        // // BinarySearch
        // System.out.println(x + " is present at " + BinarySearch(arr, x) + " index in
        // the array" + Arrays.toString(arr));

        // // Recursive Binary Search
        // System.out.println(x + " is present at " + RecursiveBinarySearch(arr, 0,
        // arr.length - 1, x)+ " index in the array" + Arrays.toString(arr));

        // // Interpolation Search
        // System.out.println(x + " is present at " + InterpolationSearch(arr, 0,
        // arr.length - 1, x)+ " index in the array" + Arrays.toString(arr));

        // Fibonacci Search
        System.out.println(x + " is present at " + FibonacciSearch(arr, x, arr.length) + " index in the array"
                + Arrays.toString(arr));
    }

    // Linear Search Method
    static int LinearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search Method
    static int BinarySearch(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // Recursive Binary Search Method
    static int RecursiveBinarySearch(int[] arr, int l, int r, int x) {
        if (l < r) {
            return -1;
        }
        int mid = (l + r) / 2;
        if (arr[mid] == x) {
            return mid;
        } else if (arr[mid] < x) {
            return RecursiveBinarySearch(arr, mid + 1, r, x);
        } else {
            return RecursiveBinarySearch(arr, l, mid - 1, x);
        }
    }

    // Interpolation Search Method
    static int InterpolationSearch(int[] arr, int l, int r, int x) {
        if (l > r || x < arr[l] || x > arr[r]) {
            return -1;
        }
        int pos = l + ((r - l) / (arr[r] - arr[l])) * (x - arr[l]);
        if (arr[pos] == x) {
            return pos;
        } else if (arr[pos] < x) {
            return InterpolationSearch(arr, pos + 1, r, x);
        } else {
            return InterpolationSearch(arr, l, pos - 1, x);
        }
    }

    // Fibonacci Search Method
    // for sorted array,O(logn),follow divide and conquer algo

    // Algo-
    // 1. find f(x) such that f(x) <= n & identify f(x-1)&f(x-2)
    // 2.1 check if y>f(x-2)th element
    // 2.2 if y==f(x-2) th element return index
    // 2.3 if y<y==f(x-2) th element then move range to f(x-4),f(x-3),f(x-2)
    // 2.4 if y<y==f(x-2) th element then move range to f(x-3),f(x-2),f(x-1)
    // 3. if there is single element left check if its 1,if yes compare y with
    // remaining element

    static int FibonacciSearch(int[] arr, int x, int n) {
        System.out.println(Arrays.toString(arr));
        System.out.println(x);

        int f2 = 0;
        int f1 = 1;
        int f = f1 + f2;

        while (f < n) {
            f2 = f1;
            f1 = f;
            f = f1 + f2;
        }

        int off = -1;
        while (f > 1) {
            int i = Math.min(off + f2, n - 1);
            if (arr[i] < x) {
                f = f1;
                f1 = f2;
                f2 = f - f1;
                off = i;
            } else if (arr[i] > x) {
                f = f2;
                f1 = f1 - f2;
                f2 = f - f1;
            } else {
                return i;
            }
        }

        if (f1 == 1 && arr[n - 1] == x) {
            return n - 1;
        }

        return -1;
    }

}