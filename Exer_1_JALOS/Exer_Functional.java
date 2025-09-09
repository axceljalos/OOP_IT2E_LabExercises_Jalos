import java.util.Arrays;

public class Exer_Functional {
    public static void main (String[]  args) {
        int[] number = {1,2,3,4,5,6,7,8,9,10};

            int sumOfOdds = Arrays.stream(number).filter(n->n % 2 != 0).sum();

            System.out.println("Functional Programming");

            System.out.println("Sum of odd numbers = " + sumOfOdds);
    }
}