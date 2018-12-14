import java.util.*;

public class Factorializer {
    public static void main(String[] args) {
        Scanner sb = new Scanner(System.in);
        System.out.print("Enter a positive number: ");
        int input = sb.nextInt(), sum = 0;
        while(input < 1) {
            System.out.println("Error, not a positive integer!");
            input = sb.nextInt();
        }
        for (int i = 1; i <= input; i+=2) 
            sum += i;
        System.out.println("The sum of all odd numbers between 1 and " + input + " is: " + sum);
    }
}