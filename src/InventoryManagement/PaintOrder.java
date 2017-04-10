package InventoryManagement;

import java.util.*;

/**
 * Created by test on 3/13/17.
 */

public class PaintOrder {

    private HashMap<String,ArrayList> inventory = new HashMap<String,ArrayList>();

    /*
     ******************************
     *
     * @param startingRed : the
     * @param startingGreen
     * @param startingYellow:
     *
     *******************************
     */
    public PaintOrder(ArrayList <Integer> startingRed, ArrayList <Integer> startingGreen, ArrayList <Integer> startingYellow){

        inventory.put("red", startingRed);
        inventory.put("green", startingGreen);
        inventory.put("yellow", startingYellow);

    }

    /**
     *
     * @param requestedTotal
     * @param colorChoice
     * @param realOrder
     * @return
     */
    public boolean orderPaint(int requestedTotal, String colorChoice, boolean realOrder) {

        if(requestedTotal > 0 && inventory.containsKey(colorChoice)) {

            boolean [][] subsetSum = SubSetSum.subSetSumMatrix(requestedTotal, inventory.get(colorChoice));
            // get the last item in the subset sum array
            boolean orderDoable = subsetSum[inventory.get(colorChoice).size()][requestedTotal];

            // the customer just wants to check if an order is possible
            if (!realOrder) {
                System.out.println("Order Possible: " + orderDoable);
                return orderDoable;
                // the customer wants to execute a real order
            }else {
                if (orderDoable) {
                    ArrayList<Integer> outputOrder = fulFillOrderAndUpdateInventory(subsetSum, this.inventory.get(colorChoice));
                    System.out.println("Checked out the following cans to fulfill the order of " +
                            requestedTotal + " liter(s) of " + colorChoice + " paint: " + outputOrder);
                    return orderDoable;
                } else {
                    System.out.println("Not possible to fulfill an order of " + requestedTotal + " liter(s) of " + colorChoice + " paint with current inventory.");
                    return orderDoable;
                }
            }
        }

        return false;
    }


    private ArrayList<Integer> fulFillOrderAndUpdateInventory(boolean [][] T, ArrayList <Integer> paintInventory){

        ArrayList<Integer> paintOrder = SubSetSum.sumSolutionList(T,paintInventory);

        // Update paintInventory by removing items that we need to for the order
        for(Integer item: paintOrder){
            paintInventory.remove(item);
        }

        return paintOrder;
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



    public ArrayList<Integer> getRedInventory(){
        return this.inventory.get("red");
    }
    public ArrayList<Integer> getGreenInventory(){
        return this.inventory.get("green");
    }
    public ArrayList<Integer> getYellowInventory(){
        return this.inventory.get("yellow");
    }


}
