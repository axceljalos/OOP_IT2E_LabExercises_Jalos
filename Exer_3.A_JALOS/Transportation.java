public class Transportation {
    String name;
    int capacity;

    public Transportation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public void move() {
        System.out.println(name + " is moving...");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Capacity: " + capacity);
    }
}

