import java.util.Arrays;

public class SearchingProblems {
    public static void main(String[] args) {

        // int arr1[] = { 1, 4, 7, 5, 6, 2 };
        // //Missing Number
        // System.out.println(missingNumber(arr1, arr1.length));

        // int arr2[] = { 1, 1, 1, 1, 1, 0, 0, 0 };
        // //No of 1_s in a binary sorted array
        // System.out.println(noOf_1s(arr2));

        // //Floor of a target
        // System.out.println(floor(arr1, 3, arr1.length));
        // //Ceiling of a target
        // System.out.println(ceiling(arr1, 3, arr1.length));

        // int[] arr3 = { 1, 2, 3, 4, 5, 5, 5, 5, 5, 9, 10, 12 };
        // System.out.println(Arrays.toString(firstLatOcuurence(arr3, 1, arr3.length)));

        // int arr5[] = { 1, 3, 4, 5, 9, -1 };
        // System.out.println(pivotIndex(arr5));

        // int arr6[] = { 1, 3, 4, 5, 10, 9, 8, 7, -1 };
        // System.out.println(peakElement(arr6));
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

    // No of 1s in binary sorted array
    public static int noOf_1s(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == 1 && (arr[mid + 1] == 0 || mid == r)) {
                return mid + 1;
            } else if (arr[mid] == 1) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return 0;
    }

    public static int floor(int[] arr, int x, int n) {
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        while (l <= r) {
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
        return arr[r];

    }

    public static int ceiling(int[] arr, int x, int n) {
        Arrays.sort(arr);
        int l = 0, r = n - 1;
        while (l <= r) {
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
        return arr[l];
    }

    public static int[] firstLatOcuurence(int[] arr, int x, int n) {
        Arrays.sort(arr);
        int f_occur = -1, l_occur = -1;
        // First Ocurrence
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                f_occur = mid;
                r = mid - 1;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        // LastOccurrence
        l = 0;
        r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == x) {
                l_occur = mid;
                l = mid + 1;
            } else if (arr[mid] < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return new int[] { f_occur, l_occur };
    }

    public static int pivotIndex(int[] nums) {
        int ts = 0;
        for (int i = 0; i < nums.length; i++) {
            ts += nums[i];
        }

        int ls = 0, rs = 0;
        for (int j = 0; j < nums.length; j++) {
            rs = ts - ls - nums[j];
            if (rs == ls) {
                return j;
            } else {
                ls += nums[j];
            }
        }
        return -1;
    }

    public static int peakElement(int[] arr) {
        int n = arr.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            // decreasing part of array
            // where r-mid can be a potential answer
            // new search space will be l to mid
            if (arr[mid] > arr[mid + 1]) {
                r = mid;
            }
            // increasing part of array where mid+1 will be greater
            // new search space will be mid+1 to r
            else {
                l = mid + 1;
            }
        }
        return l;
    }

     public static int findPeakElement(int[] nums) {
         
    int si=0,ei=nums.length-1,mid=0;
    
        while(si<ei){
        mid=(si+ei)/2;
        if(nums[mid]>nums[mid+1]){
        ei=mid;
        }
        else{
        si=mid+1;
        }
        }
        return si; 
    }


