import java.util.Arrays;

public class RecursionString {
    public static void main(String[] args) {
        // String str1 = "axacacszxzxxas";
        // System.out.println(removeX(str1));

        // String str2 = "abcdeesdabcaaddcdacd";
        // System.out.println(replaceCharacter(str2, 'a', 'x'));

        // String str3 = "assaaaaavdsss";
        // System.out.println(removeDuplicates(str3));

        int[] arr = { 1, 7, 12, 5, 3, 4, 6 };
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static String removeX(String s) {
        if (s.length() == 0) {
            return "";
        }
        String sub = removeX(s.substring(1));
        if (s.charAt(0) == 'x') {
            return sub;
        } else {
            return s.charAt(0) + sub;
        }
    }

    private static String replaceCharacter(String s, char ch1, char ch2) {
        if (s.length() == 0) {
            return "";
        }
        String sub = replaceCharacter(s.substring(1), ch1, ch2);

        if (s.charAt(0) == ch1) {
            return ch2 + sub;
        } else {
            return s.charAt(0) + sub;
        }
    }

    private static String removeDuplicates(String s) {
        if (s.length() == 1) {
            return "" + s.charAt(0);
        }
        String sub = removeDuplicates(s.substring(1));

        if (s.charAt(0) == sub.charAt(0)) {
            return sub;
        } else {
            return s.charAt(0) + sub;
        }
    }
}