public class BitOperations {

    static boolean getBit(int num, int i) {
        System.out.println(num);
        System.out.println(1 << i);
        System.out.println(num & (1 << i));
        return ((num & (1 << i)) != 0);
    }

    static int setBit(int num, int i) {
        System.out.println(num);
        System.out.println(1 << i);
        System.out.println(num & (1 << i));
        return num | (1 << i);
    }

    static int clearBit(int num, int i) {

        System.out.println(1 << i);
        int mask = ~(1 << i);
        System.out.println(mask);
        System.out.println(num & mask);
        return num & mask;
    }

    public static void main(String[] args) {
        int x = 10;
        // System.out.println(getBit(x, 3));
        // System.out.println(setBit(x, 0));
        System.out.println(clearBit(x, 1));
        System.out.println(x & 1);
    }
}