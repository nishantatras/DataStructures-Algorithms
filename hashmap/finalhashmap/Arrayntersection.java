import java.util.HashMap;
import java.util.Set;

public class Arrayntersection {
    public static void main(String[] args) {
        int arr1[] = { 1, 2, 5, 3, 2 };
        int arr2[] = { 3, 2, 2 };
        printIntersection(arr1, arr2);
    }

    public static void printIntersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (map.containsKey(arr1[i])) {
                map.put(arr1[i], map.get(arr1[i]) + 1);
            } else {
                map.put(arr1[i], 1);
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                System.out.println(arr2[i]);
                if (map.get(arr2[i]) == 1) {
                    map.remove(arr2[i]);
                } else {
                    map.put(arr2[i], map.get(arr2[i]) - 1);
                }
            }
        }

    }
}
