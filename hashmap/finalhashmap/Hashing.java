public class Hashing {
    public static void main(String[] args) {
        String x = new String("nishant");
        System.out.println(x.hashCode());

        Integer y = 140134;
        System.out.println(y.hashCode());

        Object z = new Object();
        System.out.println(z.hashCode());

        Vehicle v1 = new Vehicle(1, "Hathi");
        System.out.println(v1.hashCode());

    }
}

class Vehicle {
    int modelNo;
    String name;

    Vehicle(int modelNo, String name) {
        this.name = name;
        this.modelNo = modelNo;
    }

    // @Override
    // public static int hashCode() {
    // }

}