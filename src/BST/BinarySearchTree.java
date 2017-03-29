package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by test on 3/25/17.
 */
// Java program to demonstrate insert operation in binary search tree
/* Class containing left and right child of current node and key value*/

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree{

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() {
        System.out.println("Constructor");
        root = null;
    }

    // This method mainly calls insertRec()
    public void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Node insertRec(Node root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Node(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        /* return the (unchanged) node pointer */
        return root;
    }

    void findMax(){
        Node ptr = this.root;
        // go to the most right-most node
        while(ptr.right != null){
            ptr = ptr.right;
        }
        System.out.println(ptr.key);
    }

    void  findMin(){
        Node ptr = this.root;
        // go to the the leftmost node
        while(ptr.left != null){
            ptr = ptr.left;
        }

        System.out.println(ptr.key);
    }

    public ArrayList preOrderTransversal(){
        ArrayList answer = new ArrayList();
        // If empty tree, return nothing
        if(this.root == null){
            return answer;}
        preOrder(this.root, answer);
        return answer;}

    private void preOrder(Node ptr, ArrayList answer){
        // Base Case
        if(ptr == null){
            return;}

        // root, leftsubtree, rightsubtree
        answer.add(ptr.key);
        // Process the left and right subtree
        preOrder(ptr.left, answer);
        preOrder(ptr.right, answer);
    }

    public ArrayList inOrderTransversal(){
        ArrayList answer = new ArrayList();
        // If empty tree, return nothing
        if(this.root == null){
            return answer;}

        inOrder(this.root, answer);
        return answer;}

    private void inOrder(Node ptr, ArrayList answer){
        // Base Case
        if(ptr == null){
            return;}

        // leftsubtree, root, rightsubtree
        inOrder(ptr.left, answer);
        answer.add(ptr.key);
        inOrder(ptr.right, answer);
    }

    public ArrayList postOrderTraversal(){

        ArrayList answer = new ArrayList();
        // If empty tree, return nothing
        if(this.root == null){
            return answer;}

        postOrder(this.root, answer);
        return answer;
    }

    private void postOrder(Node ptr, ArrayList answer){
        // Base Case
        if(ptr == null){
            return;}

        // Left-subtree, Right-subtree, Root
        postOrder(ptr.left, answer);
        postOrder(ptr.right, answer);
        answer.add(ptr.key);
    }

    public ArrayList BreadthFirstSearch(){
        ArrayList answer = new ArrayList();
        // If empty tree, return nothing
        if(this.root == null){
            return answer;}

        Node ptr = this.root;
        Queue<Node> P = new LinkedList<>();

        P.add(ptr);

        while(P.isEmpty() == false){
            if(P.peek() == null){
                P.remove();
                continue;
            }
            answer.add(P.peek().key);
            Node parent = P.remove();
            if(parent == null){
                P.remove();
                continue;}
                P.add(parent.left);
                P.add(parent.right);
        }
        return answer;
    }

    public int sumOfCoveredNodes(){
        ArrayList uncovered = new ArrayList();
        // If empty tree, return nothing
        if(this.root == null){
            return 0;}

        Node ptr = this.root;
        uncovered.add(this.root.key);
        // Get the items of the right boundry
        // go to the most right-most node
        while(ptr.right != null){
            uncovered.add(ptr.right.key);
            ptr = ptr.right;
        }

        ptr = this.root;
        // Get the items of the left boundry
        // go to the most right-most node
        while(ptr.left != null){
            uncovered.add(ptr.left.key);
            ptr = ptr.left;
        }

        System.out.println("Uncovered nodes are" + uncovered);

        // get the all the items the whole tree
        ArrayList allNodes = this.BreadthFirstSearch();

        // Calculate sum of all nodes
        int sumAll = 0;
        for(int i = 0; i < allNodes.size(); i++){
            sumAll += (int)allNodes.get(i);
        }

        // Calculate sum of all uncoveered nodes
        int sumUncovered = 0;
        for(int i = 0; i < uncovered.size(); i++){
            sumUncovered += (int)uncovered.get(i);
        }

        int difference = sumAll - sumUncovered;

        return difference;
    }

    public int shortestPath(){
        ArrayList<Integer> pathDistances = new ArrayList<Integer>();
        // If empty tree, return nothing
        if(this.root == null){
            return 0;}

        Node ptr = this.root;

        calculateShortestPath(0, ptr, pathDistances);
        // calculateShortestPath(this.root.key, ptr.left, pathDistances);

        int min = Integer.MAX_VALUE;
        for(int i = 0; i < pathDistances.size(); i++){
            if(pathDistances.get(i) < min){
                min = pathDistances.get(i);
            }
        }
        return min;
    }

    private void calculateShortestPath(int sumsoFar, Node ptr, ArrayList<Integer> pathDistances) {
        // if-elseif-else statements stop doing comparisons as soon as it finds one that's true.
        // if-if-if does every comparison
        // reached a leag node, so put the path cost inside the array list
        if (ptr.right == null && ptr.left == null) {
            pathDistances.add(sumsoFar + ptr.key);
            return;
        } // if only has left child
        else if (ptr.right == null){
            calculateShortestPath(sumsoFar + ptr.key, ptr.left, pathDistances);
        } // if only has right child
        else if (ptr.left == null) {
            calculateShortestPath(sumsoFar + ptr.key, ptr.right, pathDistances);
        } // if has both children
        else {
            calculateShortestPath(sumsoFar + ptr.key, ptr.right, pathDistances);
            calculateShortestPath(sumsoFar + ptr.key, ptr.left, pathDistances);
        }
    }

}
