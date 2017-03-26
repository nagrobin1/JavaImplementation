package BST;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by test on 3/25/17.
 */

public class BreadthFirstSearch extends BinarySearchTree {


    public static void main(String [] args){

        BinarySearchTree B = new BinarySearchTree();

        B.insert(15);
        B.insert(10);
        B.insert(20);
        B.insert(8);
        B.insert(12);
        B.insert(17);
        B.insert(25);
        B.insert(30);

        B.findMax();
        B.findMin();
        // Depth First Search
        B.preOrderTransversal();
        B.inOrderTransversal();
        B.postOrderTraversal();

        HashMap<Integer, Integer> r = new HashMap<Integer, Integer>();

        Map<Integer, Integer> s = new HashMap<>();

        Has
    }








}
