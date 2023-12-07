public class ActivitySelection {
    public static void main(String[] args) {
        int s[] = { 1, 5, 4, 9, 7, 8, 13 };
        int f[] = { 2, 7, 8, 11, 12, 15, 15 };

        System.out.println("Activity Selection:");
        System.out.println("Activity|Duration");
        System.out.println("0          " + (f[0] - s[0]));

        int j = 0, count = 0;
        for (int i = 1; i < f.length; i++) {
            if (f[j] <= s[i]) {
                System.out.println(i + "          " + (f[i] - s[i]));
                j = i;
                count++;
            }
        }

        System.out.println("Maximum Activities performed is: " + (count + 1));
    }
}