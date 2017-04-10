package InventoryManagement;

import java.util.ArrayList;

/**
 * Created by test on 4/10/17.
 */
public class SubSetSum {



    public static boolean[][] subSetSumMatrix(int requestedSum, ArrayList<Integer> valuesCollection) {

        // OrderPossible[i][j] indicates whether j liters of paint can be
        // made from cans 0 to i, with each having a different size
        // requestedTotal + 1 because we need to go from 0 liters to requestedTotal liters
        // inventory.length + 1 because we need to have a hypothetical can size of 0, in order to avoid index out of
        // bound for the first iteration
        boolean[][] SubsetSumPossibleMatrix = new boolean[valuesCollection.size() + 1][requestedSum + 1];

        // 0 liter total can be made with any type of can sizes
        // Trivial Case: Can make 0 by not picking any of the cans
        for (int i = 0; i <= valuesCollection.size(); i++) {
            SubsetSumPossibleMatrix[i][0] = true;
        }

        for (int i = 1; i <= valuesCollection.size(); i++) {
            for (int currentSum = 1; currentSum <= requestedSum; currentSum++) {
                // If the current can size is bigger than the currentTotal, then
                // just copy the value from the previous can size
                if(valuesCollection.get(i - 1) > currentSum){
                    SubsetSumPossibleMatrix[i][currentSum] = SubsetSumPossibleMatrix[i - 1][currentSum];
                }
                // Else if the current can size is equal or smaller than currentTotal,
                // then we have two options:
                // 1. Possible to make currentTotal by only using past cans, OR
                // 2. Possible to make currentTotal by  using the past cans and current can
                else{
                    SubsetSumPossibleMatrix[i][currentSum] = SubsetSumPossibleMatrix[i - 1][currentSum] ||
                            SubsetSumPossibleMatrix[i - 1][currentSum - valuesCollection.get(i - 1)];
                }
            }
        }

        return SubsetSumPossibleMatrix;

    }

    public static ArrayList<Integer> sumSolutionList(boolean [][] sub_SetSumMatrix, ArrayList<Integer> valuesCollection){

        ArrayList<Integer> solutionList = new ArrayList<>();
        backTrackSubSetSumMatrix(sub_SetSumMatrix, sub_SetSumMatrix.length-1, sub_SetSumMatrix[sub_SetSumMatrix.length-1].length - 1, solutionList, valuesCollection);
        return solutionList;

    }

    private static void backTrackSubSetSumMatrix(boolean [][] sub_SetSumMatrix, int i, int j, ArrayList<Integer> solutionList, ArrayList <Integer> valuesCollection){

        // Base Case
        if(j == 0){
            return;
        }else if(sub_SetSumMatrix[i-1][j] == false){
            solutionList.add(valuesCollection.get(i-1));
            backTrackSubSetSumMatrix(sub_SetSumMatrix, i-1, j-valuesCollection.get(i-1), solutionList, valuesCollection);
        }else{
            backTrackSubSetSumMatrix(sub_SetSumMatrix, i-1, j, solutionList, valuesCollection);
        }
    }
}
