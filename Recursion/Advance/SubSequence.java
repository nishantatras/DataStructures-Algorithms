import java.sql.Array;
import java.util.Arrays;

public class SubSequence {
    public static void main(String[] args) {
        // String[] seq = findSubSequence("xyz");
        // System.out.println(Arrays.toString(seq));
        printSubSequence("abcd", "");
    }

    private static String[] findSubSequence(String s) {
        if (s.length() == 0) {
            String[] ans = { "" };
            return ans;
        }

        String[] sub = findSubSequence(s.substring(1));
        String[] ans = new String[2 * sub.length];

        for (int i = 0; i < sub.length; i++) {
            ans[i] = sub[i];
        }

        for (int i = 0; i < sub.length; i++) {
            ans[i + sub.length] = s.charAt(0) + sub[i];
        }
        return ans;
    }

    private static void printSubSequence(String up, String p) {
        if (up.length() == 0) {
            System.out.println(p);
            return;
        }
        printSubSequence(up.substring(1), p);
        printSubSequence(up.substring(1), p + up.charAt(0));
    }
}