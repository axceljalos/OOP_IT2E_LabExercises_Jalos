public class WaterTransport extends Transportation {
    public WaterTransport(String name, int capacity) {
        super(name, capacity);
    }

    public void move() {
        System.out.println(name + " is sailing on the water!");
    }
} 