import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @since 17.12.2022
 */

public class StoreUsingFiles_20210808053 {
    public static void main (String[]args) throws Exception {
        int length = countProducts(args[0] +"_ProductInfo.txt");
        String[] ID = new String[length];
        String[] name = new String[length];
        int[] quantity = new int[length];
        double[] price = new double[length];

        getProductInfo(ID,name,quantity,price,args[0] +"_ProductInfo.txt");

        int length2 = countProducts(args[0] +"_Order.txt");
        Scanner reader2 = new Scanner(new File(args[0] +"_Order.txt"));
        String[] ID2 = new String[length2];
        int[] quantity2 = new int[length2];
        for(int i = 0; i < length2; i++){
            ID2[i] = reader2.next();//Customer's order
            quantity2[i] = reader2.nextInt();//Customer's order
        }
        File file = new File(args[0] +".log.txt");
        PrintWriter printWriter = new PrintWriter(file);
        double[] total = new double[length];
        int[] order = new int[length2];
        boolean a = true;// no error
        for(int j = 0; j < length2; j++){
            for (int k =0; k < length; k++){
                if(ID2[j].equals(ID[k])){
                    if(quantity2[j] >= 0){
                        if (quantity2[j] <= quantity[k]){
                            quantity[k] = quantity[k] - quantity2[j];
                            total[k] = quantity2[j] * price[k];
                            order[k] += quantity2[j];

                        }else{
                            printWriter.print("ERROR: " + name[k] + " - " + quantity2[j] + " requested but only " + quantity[k] + " remaining\n");
                        }
                    }else{
                        printWriter.printf("ERROR: Invalid amount request (%d)\n",quantity2[j]);
                    }
                    a = true;
                    break;
                }else {
                    a = false;
                }
            }
            if (!a){
                printWriter.print("ERROR: " + ID2[j] + " not found.\n");
            }
        }
        printWriter.close();

        writeProductInfo(ID,name,quantity,price,args[0] +"_ProductAfterOrder.txt");

        File file2 = new File(args[0] +"_Receipt.txt");
        printWriter = new PrintWriter(file2);
        printWriter.println("***********CUSTOMER RECEIPT**********");
        double total2 = 0;
        for(int n = 0; n < total.length; n++){
            if(total[n] != 0){
                printWriter.println(name[n] +" (" + ID[n] + ")" + " - " + order[n] +" * " + price[n] + " = " + total[n]);
                total2 += total[n];

            }
        }
        printWriter.println("-------------------------------------");
        printWriter.println("total due - " + total2);
        printWriter.close();


    }
    public static int countProducts(String fileName)throws Exception{
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        int count = 0;
        while (reader.hasNextLine()){
            reader.nextLine();
            count++;

        }
        reader.close();
        return count;
    }
    public static void getProductInfo(String[] itemID, String[] itemName, int[] quantity, double[] price, String fileName) throws Exception {

        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        for(int i = 0; i < itemID.length; i++) {

            itemID[i] = reader.next();
            itemName[i] = reader.next();
            quantity[i] = reader.nextInt();
            price[i] = reader.nextDouble();

        }
        reader.close();
    }
    public static void writeProductInfo (String[] itemID, String[] itemName, int[] quantity, double[] price, String fileName) throws Exception {
        File file = new File(fileName);
        PrintWriter pWriter = new PrintWriter(file);
        for(int i = 0; i < itemID.length; i++){
            pWriter.println(itemID[i]+" " +  itemName[i]+" " + quantity[i]+" "+ price[i]);
        }

        pWriter.close();
    }
}
