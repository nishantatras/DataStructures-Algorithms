public class TowerofHanoi {
    public static void main(String[] args) {
        int disks = 3;
        towerOfHanoi(disks, "1", "2", "3");
    }

    private static void towerOfHanoi(int disks, String source, String aux, String dest) {
        if (disks == 0) {
            return;
        }
        towerOfHanoi(disks - 1, source, dest, aux);
        System.out.println(source + " " + dest);
        towerOfHanoi(disks - 1, aux, source, dest);
    }
}
