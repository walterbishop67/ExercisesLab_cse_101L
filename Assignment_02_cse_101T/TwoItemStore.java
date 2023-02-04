import java.util.Scanner;

/**
 * @since 8.11.2022
 */

public class TwoItemStore {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("--------Store Inventory--------");

        System.out.print("Enter the name of product 1: ");
        String product1 = input.nextLine().toLowerCase();//Name of product 1
        product1 = product1.substring(0, 1).toUpperCase() + product1.substring(1);

        System.out.print("Enter the number of " + product1 + " we have: ");
        int product1Number = input.nextInt();//number of products in the store

        if (product1Number >= 0) {
            System.out.print("Enter cost of " + product1 + ": ");
            double costOfProduct1 = input.nextDouble();//cost of product 1

            if (costOfProduct1 >= 0) {
                System.out.print("Enter the name of product 2: ");

                String product2 = input.next().toLowerCase();//Name of product 2
                product2 = product2.substring(0,1).toUpperCase() + product2.substring(1);

                System.out.print("Enter the number of " + product2 + " we have: ");
                int product2Number = input.nextInt();//number of products in the store

                if (product2Number >= 0) {
                    System.out.print("Enter cost of " + product2 + ": ");
                    double costOfProduct2 = input.nextDouble();//cost of product 2

                    if (costOfProduct2 >= 0) {
                        System.out.println("--------Customer User Interface--------");

                        int check = 1; //menu option requested by the customer.
                        int product1NumberCheck = 0;//amount of product1 requested by the customer
                        int sumProduct1 = 0;//the total number of products requested by the customer
                        int sumProduct2 = 0;//the total number of products requested by the customer
                        int product2NumberCheck = 0;//amount of product2 requested by the customer
                        double totalCostP1 = 0;//total price of products purchased by the customer
                        double totalCostP2 = 0;//total price of products purchased by the customer

                        while(check != 0){
                            System.out.println("Welcome to our store. We have the following." +
                                    " Please enter what you would like: ");

                            System.out.println("1 - " + product1 + "\n" + "2 - " + product2 +
                                    "\n0 - checkout");
                            check = input.nextInt();

                            if (check == 1){
                                System.out.printf("How many %s would you like? " , product1);
                                product1NumberCheck = input.nextInt();

                                if (product1NumberCheck > 0 ){

                                    if ((product1Number - product1NumberCheck) >= 0 ){
                                        sumProduct1 = product1NumberCheck + sumProduct1;
                                        totalCostP1 = costOfProduct1 * sumProduct1;
                                        product1Number = product1Number - sumProduct1;

                                    } else
                                        System.out.println("ERROR: We don't have that many remaining.");

                                } else if (product1NumberCheck < 0)
                                    System.out.println("ERROR: Invalid request amount!!");

                                else
                                    System.out.println("ERROR: Value can not be zero!!");

                            } else if (check == 2) {
                                System.out.printf("How many %s would you like? " , product2);
                                product2NumberCheck = input.nextInt();

                                if (product2NumberCheck > 0){

                                    if ((product2Number - product2NumberCheck) >= 0){
                                        sumProduct2 = product2NumberCheck + sumProduct2;
                                        totalCostP2 = costOfProduct2 * sumProduct2;
                                        product2Number = product2Number - sumProduct2;

                                    } else
                                        System.out.println("ERROR: We don't have that many remaining.");

                                } else if (product2NumberCheck < 0)
                                    System.out.println("ERROR: Invalid request amount!!");

                                else
                                    System.out.println("ERROR: Value can not be zero!!");

                            } else if (check != 0)
                                System.out.println("ERROR: Invalid menu option.");

                        }

                        System.out.println("--------Customer Total--------");

                        if (product1NumberCheck != 0)
                            System.out.println(product1 + " - " + sumProduct1 + " X " + costOfProduct1 +
                                    " = " + totalCostP1);

                        if(product2NumberCheck != 0)
                            System.out.println(product2 + " - " + sumProduct2 + " X " + costOfProduct2 +
                                    " = " + totalCostP2);

                        System.out.println("------------------------------");
                        System.out.println("Total due - " + (totalCostP1 + totalCostP2));

                        System.out.println("--------Final Report--------");
                        System.out.println(product1 + " - " + product1Number);
                        System.out.println(product2 + " - " + product2Number);

                    } else
                        System.out.println("ERROR: Value can not be negative!!Exiting.");

                }else
                    System.out.println("ERROR: Value can not be negative!!Exiting.");

            }else
                System.out.println("ERROR: Value can not be negative!!Exiting.");

        }else
            System.out.println("ERROR: Value can not be negative!!Exiting.");
    }
}