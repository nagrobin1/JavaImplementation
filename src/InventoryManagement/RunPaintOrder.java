package InventoryManagement;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by test on 4/8/17.
 */
public class RunPaintOrder {

    public static void main(String args[]) {

        Scanner g = new Scanner(System.in);
        Scanner r = new Scanner(System.in);
        Scanner y = new Scanner(System.in);
        Scanner a = new Scanner((System.in));
        Scanner mc = new Scanner((System.in));
        int quantity;
        System.out.println("Initialize the inventory.");

        System.out.println("1. Initialize the Red color inventory, use positive integers, separated by commas, no spaces. Example: 2,3,5,6");
        ArrayList<Integer> initialRedInventory = initializeInventory(r);

        System.out.println("2. Initialize the Green color inventory, use positive integers, separated by commas, no spaces. Example: 2,3,5,6 ");
        ArrayList<Integer> initialGreenInventory = initializeInventory(g);

        System.out.println("3. Initialize the Yellow color inventory, use positive integers, separated by commas, no spaces. Example: 2,3,5,6");
        ArrayList<Integer> initialYellowInventory = initializeInventory(y);

        PaintOrder order1 = new PaintOrder(initialRedInventory, initialGreenInventory, initialYellowInventory);

        int menuChoice = 1;

        while(menuChoice != -1){
            System.out.println("---------------------------------------------");
            System.out.println("Please select one of the options below by typing in the number next to the option. Hit -1 to end program");
            System.out.println("1. Order Red Paint");
            System.out.println("2. Order Green Paint");
            System.out.println("3. Order Yellow Paint");
            System.out.println("4. Check if Red Paint order is possible");
            System.out.println("5. Check if Green Paint order is possible");
            System.out.println("6. Check if Yellow Paint order is possible");
            System.out.println("7. Print Inventory");
            System.out.println("---------------------------------------------");
            menuChoice = mc.nextInt();

            switch (menuChoice){
                case 1:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Red paint?");
                    quantity = a.nextInt();
                    order1.orderPaint(quantity,"red", true);
                    break;
                case 2:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Green paint?");
                    quantity = a.nextInt();
                    order1.orderPaint(quantity, "green", true);
                    break;
                case 3:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Yellow paint?");
                    quantity = a.nextInt();
                    order1.orderPaint(quantity, "yellow", true);
                    break;
                case 4:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Red paint you are thinking of ordering?");
                    quantity = a.nextInt();
                    System.out.println("Possible Order: " + order1.orderPaint(quantity, "red", false));
                    break;
                case 5:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Green paint you are thinking of ordering?");
                    quantity = a.nextInt();
                    System.out.println("Possible Order: " + order1.orderPaint(quantity, "green", false));
                    break;
                case 6:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Yellow paint you are thinking of ordering?");
                    quantity = a.nextInt();
                    System.out.println("Possible Order: " + order1.orderPaint(quantity, "yellow", false));
                    break;
                case 7:
                    System.out.println("---------------------------------------------");
                    order1.printInventory();
            }

        }
    }

    public static ArrayList<Integer> initializeInventory(Scanner x){

        ArrayList<Integer> initialInventory = new ArrayList<Integer>();
        String inventory = x.next();
        Scanner s = new Scanner(inventory).useDelimiter(",");
        while (s.hasNext()) {
            int input = s.nextInt();
            // Only accept negative numbers
            if(input > 0){
                initialInventory.add(input);
            }
        }

        return initialInventory;
    }
}
