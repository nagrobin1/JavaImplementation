package BST;

import java.util.ArrayList;

/**
 * Created by test on 3/25/17.
 */

public class BreadthFirstSearch extends BinarySearchTree {


    public static void main(String [] args){

            /* Let us create following BST
              15
           /     \
          11      20
         /  \    /  \
        8   12  17  25
       /             \
      7             30 */


        BinarySearchTree B = new BinarySearchTree();

        B.insert(15);
        B.insert(11);
        B.insert(20);
        B.insert(8);
        B.insert(12);
        B.insert(17);
        B.insert(25);
        B.insert(30);
        B.insert(7);

       // System.out.println("The largest item is "); B.findMax();
        //B.findMin();
        // Depth First Search
        ArrayList preorder = B.preOrderTransversal();
        //System.out.println(preorder);
        ArrayList inorder = B.inOrderTransversal();
        //System.out.println(inorder);
        ArrayList postorder = B.postOrderTraversal();
        //System.out.println(postorder);
        ArrayList bfs = B.BreadthFirstSearch();
        System.out.println(bfs);

        //System.out.println(B.sumOfCoveredNodes());
        // shortest path from root to leaf 15-11-12
        //System.out.println(B.shortestPath());

        System.out.println("Found 18: " + B.search(18)); // false
    }


}
