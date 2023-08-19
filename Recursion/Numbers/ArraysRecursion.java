import java.util.*;

public class ArraysRecursion {
    public static void main(String[] args) {
        int arr1[] = { 1, 23, 4, 5, 3, 23, 1, 2, 4 };
        int arr2[] = { 1, 2, 4, 6, 7, 8, 11 };
        // System.out.println(firstIndex(arr, 4, 0));
        // System.out.println(isSorted1(arr2));
        // System.out.println(isSorted1(arr1));

        // System.out.println(isSorted2(arr2, arr2.length - 1));
        // System.out.println(isSorted2(arr1, arr1.length - 1));

        // System.out.println(isSorted3(arr2, 0));
        // System.out.println(isSorted3(arr1, 0));

        // System.out.println(isSorted4(arr2));
        // System.out.println(isSorted4(arr1));

        // System.out.println(sumOfArray1(arr1));
        // System.out.println(sumOfArray1(arr2));

        // System.out.println(sumOfArray2(arr1, 0));
        // System.out.println(sumOfArray2(arr2, 0));

        // System.out.println(checkNum1(arr1, 0, 2));
        // System.out.println(checkNum1(arr1, 0, 17));

        // System.out.println(firstIndex(arr1, 0, 4));

        // System.out.println(lastIndex(arr1, 0, 23));

        // ArrayList<Integer> ans = new ArrayList<Integer>();
        // allIndex(arr1, 0, 23, ans);
        // System.out.println(ans);
    }

    private static boolean isSorted1(int[] arr) {
        // if (arr.length <= 1) {
        // return true;
        // }

        // int op[] = new int[arr.length - 1];
        // for (int i = 0; i < op.length; i++) {
        // op[i] = arr[i + 1];
        // }

        // boolean ans = isSorted1(op);
        // if (ans) {
        // return (arr[0] < arr[1]) ? true : false;
        // } else {
        // return false;
        // }
        if (arr.length <= 1) {
            return true;
        }

        if (arr[0] > arr[1]) {
            return false;
        }
        int op[] = new int[arr.length - 1];
        for (int i = 0; i < op.length; i++) {
            op[i] = arr[i + 1];
        }

        boolean ans = isSorted1(op);
        return ans;
    }

    private static boolean isSorted2(int[] arr, int i) {
        // if (i == 0) {
        // return true;
        // }

        // boolean ans = isSorted2(arr, --i);
        // if (ans) {
        // return (arr[i] < arr[i + 1]) ? true : false;
        // } else {
        // return false;
        // }

        if (i == 0) {
            return true;
        }

        if (arr[i] < arr[i - 1]) {
            return false;
        }

        boolean ans = isSorted2(arr, --i);
        return ans;
    }

    private static boolean isSorted3(int[] arr, int i) {
        // if (i == arr.length - 1) {
        // return true;
        // }

        // boolean ans = isSorted3(arr, ++i);
        // if (ans) {
        // return (arr[i - 1] < arr[i]) ? true : false;
        // } else {
        // return false;
        // }

        if (i == arr.length - 1) {
            return true;
        }

        if (arr[i] > arr[i + 1]) {
            return false;
        }

        boolean ans = isSorted3(arr, ++i);
        return ans;
    }

    private static int sumOfArray1(int[] arr) {
        if (arr.length == 1) {
            return arr[0];
        }

        int[] op = new int[arr.length - 1];
        for (int i = 0; i < op.length; i++) {
            op[i] = arr[i + 1];
        }
        return arr[0] + sumOfArray1(op);
    }

    private static int sumOfArray2(int[] arr, int i) {
        if (i == arr.length - 1) {
            return arr[arr.length - 1];
        }

        return arr[i] + sumOfArray2(arr, ++i);
    }

    private static boolean checkNum1(int[] arr, int i, int x) {
        if (i == arr.length) {
            return false;
        }

        if (arr[i] == x) {
            return true;
        }

        return checkNum1(arr, ++i, x);
    }

    private static boolean isSorted4(int[] arr) {
        return isSorted3(arr, 0);
    }

    private static int firstIndex(int[] arr, int i, int x) {
        if (i == arr.length) {
            return -1;
        }
        if (arr[i] == x) {
            return i;
        }
        return firstIndex(arr, i + 1, x);
    }

    private static int lastIndex(int[] arr, int i, int x) {
        // if (i == -1) {
        // return -1;
        // }
        // if (arr[i] == x) {
        // return i;
        // }
        // return lastIndex(arr, i - 1, x);

        if (i == arr.length) {
            return -1;
        }

        int ans = lastIndex(arr, i + 1, x);
        if (ans != -1) {
            return ans;
        } else {
            if (arr[i] == x) {
                return i;
            } else {
                return -1;
            }
        }
    }

    private static void allIndex(int[] arr, int i, int x, ArrayList<Integer> ans) {
        if (i == arr.length) {
            return;
        }
        if (arr[i] == x) {
            ans.add(i);
        }
        allIndex(arr, i + 1, x, ans);
    }

}
