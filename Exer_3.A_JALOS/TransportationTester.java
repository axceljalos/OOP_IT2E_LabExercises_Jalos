public class TransportationTester {
    public static void main(String[] args) {
        // For Air Transport
        Transportation airplane = new Airplane();
        Transportation helicopter = new Helicopter();

        // For Land Transport
        Transportation truck = new Truck();
        Transportation suv = new SUV();
        Transportation tricycle = new Tricycle();
        Transportation motorcycle = new Motorcycle();
        Transportation kariton = new Kariton();

        // For Water Transport
        Transportation ship = new Ship();
        Transportation submarine = new Submarine();
 
        // Tanan ni...
        Transportation[] transports = {
            airplane, helicopter, truck, suv, tricycle, motorcycle, kariton, ship, submarine
        };

        for (Transportation t : transports) {
            t.displayInfo();
            t.move();
            System.out.println("------------------");
        }
    }
} 