import java.util.*;

public class Sales
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the amount of employees: ");
        final int SALESPEOPLE = keyboard.nextInt();
        int[] sales = new int[SALESPEOPLE];
        int sum, large = 0, lperson = 0, sperson = 0, small = 0;

        for (int i=0; i<sales.length; i++)
        {
            System.out.print("\nEnter sales for salesperson " + i + ": ");
            sales[i] = keyboard.nextInt();
        }

        System.out.println("\nSalesperson   Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i=0; i<sales.length; i++)
        {
            System.out.println("     " + i + "         " + sales[i]);
            sperson = (small > sales[i]) ? i+1 : sperson;
            small = (small > sales[i]) ? sales[i] : small;
            lperson = (large < sales[i]) ? i+1 : lperson;
            large = (large < sales[i]) ? sales[i] : large;
            sum += sales[i];
        }

        System.out.println("\nTotal sales: " + sum);
        System.out.println("\nAverage sales: " + sum/sales.length);
        System.out.println("\n" + sperson + " got the smallest amount of sales: " + small + "\n" + lperson + " got the largest amount of sales: " + large);
        System.out.println("\nEnter the number for sales to exceed: ");
        int exceeding = keyboard.nextInt();
        for (int i = 0; i < sales.length; i++) {
            String next = (sales[i] >= exceeding) ? ("\n" + i+1 + ": " + sales[i]) : "";
            System.out.print(next);
        }
    }
}
