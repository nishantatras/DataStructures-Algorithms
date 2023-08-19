public class MapUse {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new Map<>();
        map.insert(2, 1);
        map.insert(1, 2);
        map.insert(3, 3);
        map.insert(4, 4);
        map.insert(5, 1);
        map.insert(6, 2);
        map.insert(7, 3);
        map.insert(8, 4);
        map.insert(9, 1);
        map.insert(10, 2);
        map.insert(11, 3);
        map.insert(12, 4);
        map.insert(13, 2);
        map.insert(14, 3);
        map.insert(15, 4);
        System.err.println(map.size());
        map.removeKey(2);
        System.out.println(map.size());
        System.out.println(map.getValue(1));
        System.out.println(map.getValue(2));
        System.out.println(map.getValue(3));
        System.err.println(map.size());
        System.out.println(map.loadFactor());
    }
}
