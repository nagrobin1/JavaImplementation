import java.util.ArrayList;

/**
 * Created by test on 3/13/17.
 */

public class SubsetSum {

    Integer [] redInventory;
    Integer [] greenInventory;
    Integer [] yellowInventory;
    



    public static boolean orderPossible(int [] inventory, int requestedTotal) {

        // OrderPossible[i][j] indicates whether j liters of paint can be
        // made from cans 0 to i, with each having a different size
        // requestedTotal + 1 because we need to go from 0 liters to requestedTotal liters
        // inventory.length + 1 because we need to have a hypothetical can size of 0, in order to avoid index out of
        // bound for the first iteration
        boolean [][] OrderPossible = new boolean[inventory.length + 1][requestedTotal + 1];

        // 0 liter total can be made with any type of can sizes
        // Trivial Case: Can make 0 by not picking any of the cans
        for (int can = 0; can <= inventory.length; can++) {
            OrderPossible[can][0] = true;
        }

        for (int can = 1; can <= inventory.length; can++) {
            for (int currentTotal = 1; currentTotal <= requestedTotal; currentTotal++) {
                // If the current can size is bigger than the currentTotal, then
                // just copy the value from the previous can size
                if(inventory[can - 1] > currentTotal){
                    OrderPossible[can][currentTotal] = OrderPossible[can - 1][currentTotal];
                }
                // Else if the current can size is equal or smaller than currentTotal,
                // then we have two options:
                // 1. Possible to make currentTotal by only using past cans, OR
                // 2. Possible to make currentTotal by  using the past cans and current can
                else{
                    OrderPossible[can][currentTotal] = OrderPossible[can - 1][currentTotal] ||
                            OrderPossible[can - 1][currentTotal - inventory[can - 1]];
                }
            }
        }

        for(boolean[] row : OrderPossible) {
            printRow(row);
        }


        return OrderPossible[inventory.length][requestedTotal];

    }

    public static ArrayList orderInfo(boolean [][] T){
        ArrayList<Integer> paintOrder = new ArrayList<>();

        getPossibleOrder(T,T.length,T[T.length].length,paintOrder);

        return paintOrder;

    }

    public static void getPossibleOrder(boolean [][] T, int i, int j, ArrayList paintOrder){

        // Base Case
        if(j == 0 || T[i][j] == false){
            return;
        }

        if(T[i-1][j] == false){
            paintOrder.add();
        }


    }


    public static void printRow(boolean[] row) {
        for (boolean i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }


    public static void main(String args[]) {

        int arr1[] = {2,3,7,8,10};
        System.out.print(orderPossible(arr1, 11));

    }
}
