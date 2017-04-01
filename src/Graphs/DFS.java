package Graphs;

import java.util.*;

/**
 * Created by test on 3/31/17.
 */
public class DFS {

    public static ArrayList DepthFirstSearch(int[][] graph, int startVertex){
        // graph is an adjacency matrix
        // Create a stack
        Stack<Integer> frontier = new Stack<>();
        // Create a set so we can track visited vertexes
        HashSet<Integer> visited = new HashSet<>();
        // Create an arrayList for the output sequence
        ArrayList<Integer> outputSequence = new ArrayList<>();

        // Push the starting vertex to the stack
        frontier.push(startVertex);

        // while the stack is not empty
        while(frontier.isEmpty() == false) {

            // pop the TOP item from the stack
            int poppedItem = frontier.pop();

            // add the popped item to visited, so we
            // never add it to the stack again
            visited.add(poppedItem);

            // add the popped item to the output sequence
            outputSequence.add(poppedItem);

            // get all the neighbors of the poppedItem
            // and add them to the stack
            for (int neighbor = 0; neighbor < graph.length; neighbor++) {
                // if there is a path between the popped item and its neighbor
                // and the neighbor has not been visited already, then
                // push to the stack
                if (graph[poppedItem][neighbor] == 1 && visited.contains(neighbor) == false)  {
                    frontier.push(neighbor);
                }
            }
        }

        return outputSequence;
    }

    public static void main(String [] args){

        // default values are 0
        // meaning no connection
        int [][] g = new int[5][5];
        // [From][To]
        g[0][1] = 1;
        g[0][2] = 1;
        g[2][0] = 1;
        g[2][3] = 1;
        g[3][3] = 1;
        System.out.println(DepthFirstSearch(g, 2));

        // Just to display the AdjacencyMatrix
        AdjacencyMatrix G = new AdjacencyMatrix(5);
        G.setMatrix(g);
        System.out.println(G.printMatrix(g));

        // Magic
        System.out.println(DepthFirstSearch(g, 2));

    }
}
