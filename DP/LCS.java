import java.util.*;

public class LCS {

    int lcs(String X, String Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X.charAt(i - 1) == Y.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    // Utility function to get max of 2 integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        long start = System.nanoTime();
        LCS lcs = new LCS();
        String S1 = "ADFDEVDFD";
        String S2 = "ASDASCDVA";
        int m = S1.length();
        int n = S2.length();

        System.out.println("Length of LCS is"
                + " " + lcs.lcs(S1, S2, m, n));
        long end = System.nanoTime();
        System.out.println("Execution Time is: " + (end - start) / 1000000 + " ms");

    }
}
