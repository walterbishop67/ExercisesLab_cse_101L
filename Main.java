
import java.util.Scanner;

/**
 * @author Umut Altun
 * Date: 19.10.2022
 */

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("--------Bread Store Inventory--------");
        System.out.print("Enter the number of bread we have: ");
        int breadNumber = input.nextInt();
        if (breadNumber >= 0) {
            System.out.print("enter cost of bread: ");
            double costOfBread = input.nextDouble();
            if (costOfBread >= 0) {
                System.out.println("--------Customer User Interface--------");
                System.out.println("Welcome to our bread store.We have " + breadNumber
                        + " loaves of bread available.");
                System.out.print("How many would you like?");
                int breadNumber2 = input.nextInt();
                if (breadNumber2 >= 1) {
                    if (breadNumber2 <= breadNumber) {
                        System.out.println("Your cost is: " + costOfBread * breadNumber2);
                        System.out.println("Thank you for shopping with us today.");
                        System.out.println("We have now " + (breadNumber - breadNumber2) +
                                " loaves of bread remaining.");
                    } else {
                        System.out.println("ERROR: We don't have that many remaining");
                        System.out.println("We have now " + (breadNumber) +
                                " loaves of bread.");
                    }
                } else {
                    System.out.println("ERROR: Value can not be negative!!");
                    System.out.println("We have now " + (breadNumber) +
                            " loaves of bread.");
                }
            } else {
                System.out.println("ERROR: Value can not be negative!!Exiting.");
            }
        } else {
            System.out.println("ERROR: Value can not be negative!!Exiting.");
        }
    }
}