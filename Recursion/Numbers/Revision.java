import java.util.*;

public class Revision {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        // System.out.println("Enter your Number");
        // int n1 = s.nextInt();
        // System.out.println("Factorial of " + n1 + " is " + factorial(n1));

        // System.out.println("Enter your Number");
        // int n2 = s.nextInt();
        // System.out.println("Enter no of multiples");
        // int noOfmultiples = s.nextInt();
        // System.out.println("Tabel for " + n2 + " :");
        // multipleTable(noOfmultiples, n2);

        // System.out.println("Enter your Number");
        // int n3 = s.nextInt();
        // System.out.println("Sum of " + n3 + " Natural Number is " +
        // sumOfnNaturalNuMBERS(n3));

        // printNumbers(5);

        // System.out.println(power(5, 5));

        // System.out.println(digits(10791));

        // System.out.println("Enter which fibonnaci number you want:");
        // int n4 = s.nextInt();
        // System.out.println(fibonacci(n4));

        // System.out.println(sumOfDigits(12234));

        System.out.println(geoSum(3, 2));
        s.close();
    }

    private static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }

    private static double geoSum(int n, double div) {
        if (n == 0) {
            return 1;
        }
        double sub = 1 / div;
        return sub + geoSum(n -= 1, div * 2);
    }

    private static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        int op = factorial(n - 1);
        return n * op;
    }

    private static void multipleTable(int n, int num) {
        if (n == 1) {
            System.out.println(num + " * " + n + " = " + num);
            return;
        }
        multipleTable(n - 1, num);
        System.out.println(num + " * " + n + " = " + n * num);
    }

    private static int sumOfnNaturalNuMBERS(int n) {
        if (n == 1) {
            return 1;
        }

        int op = sumOfnNaturalNuMBERS(n - 1);
        return n + op;
    }

    private static void printNumbers(int n) {
        if (n == 0) {
            return;
        }
        printNumbers(n - 1);
        System.out.println(n);
    }

    private static int power(int num, int x) {
        if (x == 0) {
            return 1;
        }
        int op = power(num, x - 1);
        return num * op;
    }

    private static int digits(int num) {
        if (num == 0) {
            return 0;
        }

        return 1 + digits(num / 10);
    }

    private static int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}