import java.util.Arrays;

public class RecursionString {
    public static void main(String[] args) {
        // String str1 = "axacacszxzxxas";
        // System.out.println(removeX(str1));

        // String str2 = "abcdeesdabcaaddcdacd";
        // System.out.println(replaceCharacter(str2, 'a', 'x'));

        // String str3 = "assaaaaavdsss";
        // System.out.println(removeDuplicates(str3));

        // System.out.println(replacePi("ascdvsdvsdpiafcdpi"));

        // System.out.println(StringtoInteger("1234"));

        System.out.println(pairStar("asdsdaaadsaad"));
    }

    private static String replacePi(String s) {
        if (s.length() == 0) {
            return "";
        }
        String sub = replacePi(s.substring(1));
        if (s.charAt(0) == 'p' && sub.charAt(0) == 'i') {
            return "3.14" + sub.substring(1);
        } else {
            return s.charAt(0) + sub;
        }
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

    private static int StringtoInteger(String s) {
        // if (s.length() == 0) {
        // return 0;
        // }

        // int sub = StringtoInteger(s.substring(0, s.length() - 1));
        // int digit = (int) (s.charAt(s.length() - 1) - 48);
        // return sub * 10 + digit;
        // }

        if (s.length() == 0) {
            return 0;
        }

        int sub = StringtoInteger(s.substring(1));
        int digit = (int) (s.charAt(0) - 48);
        return sub * 10 + digit;
    }

    private static String pairStar(String s) {
        if (s.length() == 1) {
            return s.charAt(0) + "";
        }
        String sub = pairStar(s.substring(1));

        if (s.charAt(0) == sub.charAt(0)) {
            return (s.charAt(0) + "*" + sub);
        } else {
            return s.charAt(0) + sub;
        }
    }
}