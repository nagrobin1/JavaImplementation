package InventoryManagement;

import java.util.*;

/**
 * Created by test on 3/13/17.
 */

public class PaintOrder {

    private HashMap<String,ArrayList> inventory = new HashMap<String,ArrayList>();


    public PaintOrder(ArrayList <Integer> startingRed, ArrayList <Integer> startingGreen, ArrayList <Integer> startingYellow){

        inventory.put("red", startingRed);
        inventory.put("green", startingGreen);
        inventory.put("yellow", startingYellow);

    }

    public boolean orderPaint(int requestedTotal, String colorChoice, boolean realOrder) {

        if(requestedTotal > 0 && inventory.containsKey(colorChoice)) {

            boolean [][] subsetSum = subSetSumMatrix(requestedTotal, colorChoice);
            // get the last item in the subset sum array
            boolean orderDoable = subsetSum[inventory.get(colorChoice).size()][requestedTotal];

            // the customer just wants to check if an order is possible
            if (!realOrder) {
                return orderDoable;
                // the customer wants to execute a real order
            } else {
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
    /*
       ***************
       *
       *
       *
       *
       * **************
     */

    private boolean[][] subSetSumMatrix(int requestedTotal, String colorChoice) {

        ArrayList <Integer> colorInventory = inventory.get(colorChoice);
        // OrderPossible[i][j] indicates whether j liters of paint can be
        // made from cans 0 to i, with each having a different size
        // requestedTotal + 1 because we need to go from 0 liters to requestedTotal liters
        // inventory.length + 1 because we need to have a hypothetical can size of 0, in order to avoid index out of
        // bound for the first iteration
        boolean[][] OrderPossible = new boolean[colorInventory.size() + 1][requestedTotal + 1];

        // 0 liter total can be made with any type of can sizes
        // Trivial Case: Can make 0 by not picking any of the cans
        for (int can = 0; can <= colorInventory.size(); can++) {
            OrderPossible[can][0] = true;
        }

        for (int can = 1; can <= colorInventory.size(); can++) {
            for (int currentTotal = 1; currentTotal <= requestedTotal; currentTotal++) {
                // If the current can size is bigger than the currentTotal, then
                // just copy the value from the previous can size
                if(colorInventory.get(can - 1) > currentTotal){
                    OrderPossible[can][currentTotal] = OrderPossible[can - 1][currentTotal];
                }
                // Else if the current can size is equal or smaller than currentTotal,
                // then we have two options:
                // 1. Possible to make currentTotal by only using past cans, OR
                // 2. Possible to make currentTotal by  using the past cans and current can
                else{
                    OrderPossible[can][currentTotal] = OrderPossible[can - 1][currentTotal] ||
                            OrderPossible[can - 1][currentTotal - colorInventory.get(can - 1)];
                }
            }
        }

        return OrderPossible;

    }

    private ArrayList<Integer> fulFillOrderAndUpdateInventory(boolean [][] T, ArrayList <Integer> paintInventory){

        ArrayList<Integer> paintOrder = new ArrayList<>();

        fulFillOrder(T, T.length-1, T[T.length-1].length - 1, paintOrder, paintInventory);

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

    // Helper functions for testing

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
