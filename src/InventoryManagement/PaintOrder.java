import java.util.*;

/**
 * Created by test on 3/13/17.
 */

public class PaintOrder {

    private Map<String,ArrayList> inventory = new HashMap<String,ArrayList>();


    public PaintOrder(ArrayList <Integer> startingGreen, ArrayList <Integer> startingRed, ArrayList <Integer> startingYellow){

        inventory.put("green", startingGreen);
        inventory.put("red", startingRed);
        inventory.put("yellow", startingYellow);

    }

    public void orderPaint(int requestedTotal, String colorChoice){

            boolean [][] OrderPossible = new boolean[inventory.get(colorChoice).size() + 1][requestedTotal + 1];

            orderOutput(requestedTotal, OrderPossible, inventory.get(colorChoice), colorChoice);
    }

    public boolean possibleOrder(int requestedTotal, String colorChoice){

        boolean [][] OrderPossible = new boolean[inventory.get(colorChoice).size() + 1][requestedTotal + 1];

        return (orderPossible(requestedTotal, OrderPossible, inventory.get(colorChoice)));
    }


    private void orderOutput(int requestedTotal, boolean [][] OrderPossible, ArrayList <Integer> colorInventory, String color){

        if(orderPossible(requestedTotal, OrderPossible, colorInventory)){
            ArrayList<Integer> outputOrder = fulFillOrderAndUpdateInventory(OrderPossible, colorInventory);
            System.out.println("Checked out the following cans to fulfill the order of " +
                    requestedTotal + " liter(s) of " + color + " paint: " +  outputOrder);
        }else{
            System.out.println("Not possible to fulfill an order of " +  requestedTotal + " liter(s) of " + color + " paint with current inventory.");
        }
    }

    public boolean orderPossible(int requestedTotal, boolean [][] OrderPossible, ArrayList <Integer> inventory) {

        // OrderPossible[i][j] indicates whether j liters of paint can be
        // made from cans 0 to i, with each having a different size
        // requestedTotal + 1 because we need to go from 0 liters to requestedTotal liters
        // inventory.length + 1 because we need to have a hypothetical can size of 0, in order to avoid index out of
        // bound for the first iteration

        // 0 liter total can be made with any type of can sizes
        // Trivial Case: Can make 0 by not picking any of the cans
        for (int can = 0; can <= inventory.size(); can++) {
            OrderPossible[can][0] = true;
        }

        for (int can = 1; can <= inventory.size(); can++) {
            for (int currentTotal = 1; currentTotal <= requestedTotal; currentTotal++) {
                // If the current can size is bigger than the currentTotal, then
                // just copy the value from the previous can size
                if(inventory.get(can - 1) > currentTotal){
                    OrderPossible[can][currentTotal] = OrderPossible[can - 1][currentTotal];
                }
                // Else if the current can size is equal or smaller than currentTotal,
                // then we have two options:
                // 1. Possible to make currentTotal by only using past cans, OR
                // 2. Possible to make currentTotal by  using the past cans and current can
                else{
                    OrderPossible[can][currentTotal] = OrderPossible[can - 1][currentTotal] ||
                            OrderPossible[can - 1][currentTotal - inventory.get(can - 1)];
                }
            }
        }

        return OrderPossible[inventory.size()][requestedTotal];

    }

    private ArrayList<Integer> fulFillOrderAndUpdateInventory(boolean [][] T, ArrayList <Integer> paintInventory){

        ArrayList<Integer> paintOrder = new ArrayList<>();

        fulFillOrder(T, T.length-1, T[T.length-1].length - 1,paintOrder, paintInventory);

        // Update paintInventory by removing items that we need to for the order
        for(Integer item: paintOrder){
            paintInventory.remove(item);
        }

        return paintOrder;
    }

    private void fulFillOrder(boolean [][] T, int i, int j, ArrayList<Integer> paintOrder, ArrayList <Integer> paintInventory){

        // Base Case
        if(j == 0){
            return;
        }else if(T[i-1][j] == false){
            paintOrder.add(paintInventory.get(i-1));
            fulFillOrder(T, i-1, j-paintInventory.get(i-1), paintOrder, paintInventory);
        }else{
            fulFillOrder(T, i-1, j, paintOrder, paintInventory);
        }
    }

    public void printInventory(){

        StringBuilder sb = new StringBuilder();
        sb.append("Current inventory:{");
        for (String color : inventory.keySet()) {
            sb.append(color + " = " + inventory.get(color) + ", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");

        System.out.println(sb.toString());

    }

    // Helper Functions for testing

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

    public static void main(String args[]) {


        Scanner g = new Scanner(System.in);
        Scanner r = new Scanner(System.in);
        Scanner y = new Scanner(System.in);
        Scanner a = new Scanner((System.in));
        Scanner mc = new Scanner((System.in));
        int quantity;
        System.out.println("Initialize the inventory.");

        System.out.println("1. Initialize the Green color inventory, use positive integers, separated by commas, no spaces. Example: 2,3,5,6 ");
        ArrayList<Integer> initialGreenInventory = initializeInventory(g);

        System.out.println("2. Initialize the Red color inventory, use positive integers, separated by commas, no spaces. Example: 2,3,5,6");
        ArrayList<Integer> initialRedInventory = initializeInventory(r);

        System.out.println("3. Initialize the Yellow color inventory, use positive integers, separated by commas, no spaces. Example: 2,3,5,6");
        ArrayList<Integer> initialYellowInventory = initializeInventory(y);

        PaintOrder order1 = new PaintOrder(initialGreenInventory, initialRedInventory, initialYellowInventory);

        int menuChoice = 1;

        while(menuChoice != -1){
            System.out.println("---------------------------------------------");
            System.out.println("Please select one of the options below by typing in the number next to the option. Hit -1 to end program");
            System.out.println("1. Order Green Paint");
            System.out.println("2. Order Red Paint");
            System.out.println("3. Order Yellow Paint");
            System.out.println("4. Check if Green Paint order is possible");
            System.out.println("5. Check if Red Paint order is possible");
            System.out.println("6. Check if Yellow Paint order is possible");
            System.out.println("7. Print Inventory");
            System.out.println("---------------------------------------------");
            menuChoice = mc.nextInt();

            switch (menuChoice){
                case 1:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Green paint?");
                    quantity = a.nextInt();
                    order1.orderPaint(quantity, "green");
                    break;
                case 2:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Red paint?");
                    quantity = a.nextInt();
                    order1.orderPaint(quantity, "red");
                    break;
                case 3:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Red paint?");
                    quantity = a.nextInt();
                    order1.orderPaint(quantity, "yellow");
                    break;
                case 4:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Green paint you are thinking of ordering?");
                    quantity = a.nextInt();
                    System.out.println("Possible Order: " + order1.possibleOrder(quantity, "green"));
                    break;
                case 5:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Red paint you are thinking of ordering?");
                    quantity = a.nextInt();
                    System.out.println("Possible Order: " + order1.possibleOrder(quantity, "red"));
                    break;
                case 6:
                    System.out.println("---------------------------------------------");
                    System.out.println("How many liters of Yellow paint you are thinking of ordering?");
                    quantity = a.nextInt();
                    System.out.println("Possible Order: " + order1.possibleOrder(quantity, "yellow"));
                    break;
                case 7:
                    System.out.println("---------------------------------------------");
                    order1.printInventory();
            }

        }
    }
}
