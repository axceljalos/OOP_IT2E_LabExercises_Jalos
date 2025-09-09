public class Car {
    public static void main (String[] args) {
        
    }
    public Car(){
        this.color = "No Color";
        this.plateNo = "No PlateNo";
        this.chassisNo = "No ChassisNo";
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
        System.out.println(info);
    }
}