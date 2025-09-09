public class CarTester {
    public static void main (String[] args){
        Car c1 = new Car (color = "Blue", plateN0 = "ATJ996", 
            chassisNo = "DYR06" );

        Car c2 = new Car();

        c1.displayInfo();
        c2.displayInfo();
    }
}