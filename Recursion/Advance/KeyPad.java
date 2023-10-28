import java.sql.Array;
import java.util.Arrays;

public class KeyPad {
    public static void main(String[] args) {
        // String[] arr = KeyPad(92);
        // System.out.println(Arrays.toString(arr));
        printKeyPad(23, "");
    }

    private static String[] KeyPad(int n) {
        if (n == 0) {
            return new String[] { "" };
        }
        String[] sub = KeyPad(n / 10);
        char[] ch = helper(n % 10);
        String[] ans = new String[sub.length * ch.length];

        int k = 0;
        for (int i = 0; i < sub.length; i++) {
            for (int j = 0; j < ch.length; j++) {
                ans[k] = sub[i] + ch[j];
                k++;
            }
        }

        return ans;
    }

    private static char[] helper(int n) {
        switch (n) {
            case 2:
                return new char[] { 'a', 'b', 'c' };
            case 3:
                return new char[] { 'd', 'e', 'f' };
            case 4:
                return new char[] { 'g', 'h', 'i' };
            case 5:
                return new char[] { 'j', 'k', 'l' };
            case 6:
                return new char[] { 'm', 'n', 'o' };
            case 7:
                return new char[] { 'p', 'q', 'r', 's' };
            case 8:
                return new char[] { 't', 'u', 'v' };
            case 9:
                return new char[] { 'w', 'x', 'y', 'z' };
        }
        return new char[] {};
    }

    private static void printKeyPad(int n, String p) {
        if (n == 0) {
            System.out.println(p);
            return;
        }

        char[] ch = helper(n % 10);

        for (int i = 0; i < ch.length; i++) {
            printKeyPad(n / 10, p + ch[i]);
        }

    }
}
