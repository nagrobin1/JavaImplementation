package InventoryManagement;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by test on 4/8/17.
 */
public class RunPaintOrder {

    public static void main(String args[]) {

        Scanner inventoryScanner = new Scanner(System.in);
        Scanner menuScanner = new Scanner((System.in));
        int menuChoice = 1;

        System.out.println("Initialize the inventory.");

        printInitializeInventory("Red");
        ArrayList<Integer> initialRedInventory = initializeInventory(inventoryScanner);

        printInitializeInventory("Green");
        ArrayList<Integer> initialGreenInventory = initializeInventory(inventoryScanner);

        printInitializeInventory("Yellow");
        ArrayList<Integer> initialYellowInventory = initializeInventory(inventoryScanner);

        PaintOrder order = new PaintOrder(initialRedInventory, initialGreenInventory, initialYellowInventory);


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

            try {
                menuChoice = menuScanner.nextInt();
            }catch(InputMismatchException e) {
                System.out.println("Only select from 1 to 7");
                menuScanner.next();
                continue;
            }


            switch (menuChoice){
                case 1:
                    uiOutput(order, "red", true);
                    break;
                case 2:
                    uiOutput(order, "green", true);
                    break;
                case 3:
                    uiOutput(order, "yellow", true);
                    break;
                case 4:
                    uiOutput(order, "red", false);
                    break;
                case 5:
                    uiOutput(order, "green", false);
                    break;
                case 6:
                    uiOutput(order, "yellow", false);
                    break;
                case 7:
                    System.out.println("---------------------------------------------");
                    order.printInventory();
            }

        }
    }

    public static ArrayList<Integer> initializeInventory(Scanner x){

        ArrayList<Integer> initialInventory = new ArrayList<Integer>();
        String inventory = x.next();
        Scanner s = new Scanner(inventory).useDelimiter(",");
        while (s.hasNextInt()) {
            int input = s.nextInt();
            // Only accept positive integers
            if(input > 0){
                initialInventory.add(input);
            }
        }
        return initialInventory;
    }

    public static void uiOutput(PaintOrder order, String colorChoice, boolean realOrder){
        int quantity;
        Scanner quantityScanner = new Scanner((System.in));
        System.out.println("---------------------------------------------");
        System.out.println("How many liters of "+ colorChoice +" paint?");
        try {
            quantity = quantityScanner.nextInt();
        }catch(InputMismatchException e) {
            System.out.println("Please enter only positive integers.");
            return;
        }
        order.orderPaint(quantity,colorChoice, realOrder);
    }

    public static void printInitializeInventory(String colorChoice){
        System.out.println("Initialize the " + colorChoice + " color inventory, use positive integers, separated " +
                "by commas, no spaces. Example: 2,3,5,6");
    }
}
