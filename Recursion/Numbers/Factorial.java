import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter your Number");
        int n = s.nextInt();

        System.out.println("Factorial of " + n + " is " + factorial(n));
        s.close();
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int op = factorial(n - 1);
        return n * op;
    }
}