package BST;

import java.util.PriorityQueue;

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

public class BinarySearchTree {

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

    void preOrderTransversal(){
        // If empty tree, return nothing
        if(this.root == null){
            return;}

        preOrder(this.root);
        System.out.println();}

    private void preOrder(Node ptr){
        // Base Case
        if(ptr == null){
            return;}

        // root, leftsubtree, rightsubtree
        System.out.print(ptr.key + ", ");
        preOrder(ptr.left);
        preOrder(ptr.right);
    }

    void inOrderTransversal(){
        // If empty tree, return nothing
        if(this.root == null){
            return;}

        inOrder(this.root);
        System.out.println();}

    private void inOrder(Node ptr){
        // Base Case
        if(ptr == null){
            return;}

        // leftsubtree, root, rightsubtree
        inOrder(ptr.left);
        System.out.print(ptr.key + ", ");
        inOrder(ptr.right);
    }

    void postOrderTraversal(){

        // If empty tree, return nothing
        if(this.root == null){
            return;}

        postOrder(this.root);
        System.out.println();
    }

    private void postOrder(Node ptr){
        // Base Case
        if(ptr == null){
            return;}

        // Left-subtree, Right-subtree, Root
        postOrder(ptr.left);
        postOrder(ptr.right);
        System.out.print(ptr.key + ", ");
    }

    void BreadthFirstSearch(){
        // If empty tree, return nothing
        if(this.root == null){
            return;}

        PriorityQueue<Interger> = new


    }

}
