public class ShirtTester {
    public static void main (String[] args){
        Shirt s1 = new Shirt (color = "Black", size = "Large", 
            brand = "Superme" );

        Shirt s2 = new Shirt();

        s1.displayInfo();
        s2.displayInfo();
    }
}