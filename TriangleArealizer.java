import java.util.*;

public class TriangleArealizer {
    public static void main(String[] args) {
        Scanner sb = new Scanner(System.in);
        System.out.println("Enter the 3 sides of the triangle seperated by spaces: ");
        String[] input = sb.nextLine().split(" ");
        double[] sides = new double[3];
        double s = 0;
        for (int i = 0; i < 3; i++) {
            sides[i] = Double.parseDouble(input[i]);
            s += sides[i]/2;
        }
        double area = Math.round(Math.sqrt(s*(s-sides[0])*(s-sides[1])*(s-sides[2]))*100d)/100d;
        System.out.println("The area of the triangle is " + area);
    }
}