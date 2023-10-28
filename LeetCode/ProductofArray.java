import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductofArray {
    public static void main(String[] args) {
        int[] arr = { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];
        boolean oneZero = false;
        boolean moreZero = false;

        int p = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && oneZero == false) {
                oneZero = true;
            } else if (nums[i] == 0 && oneZero == true) {
                moreZero = true;
            } else {
                p = p * nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (moreZero == true) {
                res[i] = 0;
            } else if (oneZero == true) {
                res[i] = p;
            } else {
                res[i] = p / nums[i];
            }
        }
        return res;
    }
}