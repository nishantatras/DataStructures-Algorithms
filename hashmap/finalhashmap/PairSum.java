import java.util.HashMap;
//TRY AGAIN

public class PairSum {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, -2, -1, -1 };
        System.out.println(pairSum(arr));
    }

    public static int pairSum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        // for (int i = 0; i < arr.length; i++) {
        // if (map.containsKey(arr[i])) {
        // System.out.println(arr[i]);
        // if (map.get(arr[i]) == 1) {
        // map.remove(arr[i]);
        // } else {
        // map.put(arr[i], map.get(arr[i]) - 1);
        // }
        // }
        // }
        return 0;
    }
}
