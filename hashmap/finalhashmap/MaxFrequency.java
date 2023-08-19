import java.util.HashMap;
import java.util.Set;

public class MaxFrequency {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 4, 3, 2, 2, 2, 2, 5 };
        System.out.println(maxFrequencyNumber(arr));
    }

    public static int maxFrequencyNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int max = 0, maxn = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) > max) {
                max = map.get(arr[i]);
                maxn = arr[i];
            }
        }

        return maxn;
    }
}
