import java.util.Arrays;

public class Exer_Declarative {
    public static void main (String[]  args) {
        int[] number = {1,2,3,4,5,6,7,8,9,10};

            long countOfeven = Arrays.stream(number).filter( n-> n % 2 == 0).count();

            System.out.println("Declarative Programming");

            System.out.println("Count of even numbers = " + countOfeven);
        

    }
}
