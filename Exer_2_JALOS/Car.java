public class Car {

    public static void main (String[] args){
        Car c1 = new Car (color = "Blue", plateN0 = "ATJ996", 
            chassisNo = "DYR06" );

        Car c2 = new Car();

        c1.displayInfo();
        c2.displayInfo();
    }

    public Car(String color, String plateNo, String chassisNo){
        this.color = color;
        this.plateNo = plateNo;
        this.chassisNo = chassisNo;
    }

    public void displayInfo(){
        String info = "";
        info += "Color: " + this.color;
        info += "PlateNo: " + this.plateNo;
        info += "ChassisNo: " + this.chassisNo;
    }
}