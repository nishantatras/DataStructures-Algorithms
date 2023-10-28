import java.util.HashMap;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0;
        while (i < nums.length) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            i++;
        }

        int j = 0, ans = 0, l = 1;
        while (j < nums.length) {
            while (map.containsKey(nums[j] + 1)) {
                l++;
            }
            if (l > ans) {
                ans = l;
            }
            j++;
        }

        return ans;
    }
}
