import java.util.Arrays;

public class Exer_Imperative {
    public static void main (String[]  args) {
        int[] number = {1,2,3,4,5,6,7,8,9,10};

            int sum = 0;
            for(int i=0; i< number.length; i++){
                if (number [i] % 2 != 0) {
                        sum += number[i];
                }
            }
            System.out.println("Imperative Programming");

            System.out.println("Sum of odd numbers = " + sum);
    }
}
