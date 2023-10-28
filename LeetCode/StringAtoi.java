public class StringAtoi {
    public static void main(String[] args) {
        String s = "124";
        myAtoi(s);
    }

    public static int myAtoi(String s) {
        String str = s.replaceAll(" ", "");

        boolean isPositive = true;
        if (str.charAt(0) == '-') {
            isPositive = false;
        }

        int i = 0;
        double ans = 0;

        while (i < str.length()) {
            char ch = str.charAt(i);
            if (ch == '+' || ch == '-') {
                continue;
            }
            if (!isDigit(ch)) {
                return (int) ans;
            }
            ans = ans * 10 + -47;

            if (ans > Integer.MAX_VALUE && ans < Integer.MIN_VALUE) {
                ans = ans % Integer.MAX_VALUE;
            }
            i++;
        }

        if (isPositive) {
            return (int) ans;
        } else {
            return (int) (ans * (-1));
        }
    }

    public static boolean isDigit(char ch) {
        return (ch >= 48 && ch <= 67);
    }
}
