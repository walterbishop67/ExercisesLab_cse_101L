/**
 * @date 1.12.2022
 */

import java.util.Scanner;

public class StoreUsingArrays{
    public static void main (String[]args) {

        String[] item = {"ekmek", "cola", "peynir", "armut"};
        int[] quantitiy = {16, 13, 12, 5};
        double[] price = {2.5, 3, 14, 3.75};

        storeRun(item, quantitiy, price);
    }

    public static int menu (String[] item, double[] price, int input) {
        Scanner in = new Scanner(System.in);

            capitalizeArray(item);

            for (int i = 0; i < item.length; i++) {
                System.out.println((i + 1) + " - " + item[i]  + " "
                        + "(" + price[i] + ")");

            }
            System.out.println("0 - to checkout");
            System.out.println("Please enter what you would like: ");
            input = in.nextInt();

        return input;
    }
    public static String returnedAmounts(double amount){
        double[] array = {200, 100, 50, 20, 10, 5,
                1, 0.50, 0.25, 0.10, 0.05, 0.01};
        String a = "";
        int temp;

        for (double v : array) {
            if(v >= 1 ){
                if (amount % v != amount) {
                    temp = (int) (amount / v);
                    amount = amount % v;
                    a += temp + " - " + (int)v + "\n";
                }
            }else{
                if (amount % v != amount) {
                    temp = (int) (amount / v);
                    amount = amount % v;
                    a += temp + " - " + v + "\n";
                }
            }
        }
        return a;
    }
    public static void storeRun(String[] item, int[] quantity, double[] price) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to our store, we have the following." +
                "Please enter what you what you would like: ");

        int input = 1;
        int[] istenen1 = new int[item.length];
        double[] hesap = new double[item.length];
        int [] last = new int[item.length];
        double hesap2 = 0;

        while (input != 0) {
            input = menu(item, price, input);
            if (input > 0 && input <= item.length) {
                for (int j = 0; j < item.length; j++) {
                    if (input == (j+1)){
                        System.out.printf("How many %s would you like? ", item[j]);
                        istenen1[j] = reader.nextInt();
                        if (istenen1[j] > 0) {
                            if (istenen1[j] <= quantity[j]) {
                                last[j] =last[j] + istenen1[j];
                                hesap[j] = last[j] * price[j];
                                quantity[j] = quantity[j] - istenen1[j];
                            } else {
                                System.out.println("ERROR: Invalid request.");
                                istenen1[j] = 0;
                            }
                        } else
                            System.out.println("ERROR: It can't be negative");
                    }
                }
            } else if (input == 0)
                System.out.println();
            else
                System.out.println("ERROR: Invalid choice.");
        }

        System.out.println("-------Customer Total-------");
        for (int k = 0; k < item.length; k++) {
            if (last[k] != 0){
                System.out.println(item[k] + " - " + last[k] + " * " + price[k]
                        + " = " + hesap[k]);
                hesap2 += hesap[k];
            }
        }
        System.out.println("----------------------------");
        System.out.println("total due - " + hesap2);

        boolean condition = false;

        while(!condition) {
            System.out.println("\nPlease enter amount given");
            double amount = reader.nextDouble();
            if (amount - hesap2 >= 0) {
                System.out.println("Thank you for your business." +
                        " Your change given is:");
                String b = returnedAmounts(amount - hesap2);
                System.out.println(b);
                condition = true;
            } else {
                System.out.println(capitalizeString("not enough payment given"));
            }
        }
    }
    public static String capitalizeString(String text) {
        if(text == null || text.length()==0)
            return "";
        return text.substring(0,1).toUpperCase() + text.substring(1).toLowerCase();
    }
    public static void capitalizeArray(String[] name) {
        for(int i = 0;i<name.length;i++){
            name[i] = capitalizeString(name[i]);
        }
    }
}
