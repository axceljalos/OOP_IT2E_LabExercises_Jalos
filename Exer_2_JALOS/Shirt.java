public class Shirt {
    public static void main (String[] args){
        
    }
    public Shirt(){
        this.color = "No Color";
        this.size = "No Size";
        this.brand = "No Brand";
    }

    public Shirt(String color, String size, String brand){
        this.color = color;
        this.size = size;
        this.brand = brand;
    }

    public void displayInfo(){
        String info = "";
        info += "Color: " + this.color;
        info += "size : " + this.size;
        info += "brand : " + this.brand;
    }
}
