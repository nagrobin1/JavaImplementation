package Graphs;

import java.util.*;

/**
 * Created by test on 3/31/17.
 *
 */
public class BFS {

    public static ArrayList BreadthFirstSearch(int[][] graph, int startVertex){
        // graph is an adjaceny matrix where
        // Create a queue
        Queue<Integer> frontier = new LinkedList<Integer>();
        // Create a set so we can track visited vertexes
        HashSet<Integer> visited = new HashSet<>();
        // Create an arrayList for the output sequence
        ArrayList<Integer> outputSequence = new ArrayList<>();

        // Add the starting vertex to the queue
        frontier.add(startVertex);

        // while the queue is not empty
        while(frontier.isEmpty() == false) {

            // if the current node has already been visited already but makes a
            // second apperarnce in the queue just dequeue it and move to
            // next item in queue.
            if(visited.contains(frontier.peek())){
                frontier.remove();
                continue;
            }

            // deque the head element of the queue
            int dequedItem = frontier.remove();

            // add the dequed item to visited, so we
            // never add it to the queue again
            visited.add(dequedItem);

            // add the dequed item to the output sequence
            outputSequence.add(dequedItem);

            // get all the neighbors of the dequedItem
            // and add them to the queue
            for (int neighbor = 0; neighbor < graph.length; neighbor++) {
                // if there is a path between the dequed item and its neighbor
                // and the neighbor has not been visited already, then
                // add to the queue
                if (graph[dequedItem][neighbor] == 1 && visited.contains(neighbor) == false)  {
                    frontier.add(neighbor);
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


        // Just to display the AdjacencyMatrix
        // AdjacencyMatrix G = new AdjacencyMatrix(5);
        // G.setMatrix(g);
        // System.out.println(G.printMatrix(g));

        // Magic
        // System.out.println(BreadthFirstSearch(g, 2));

        int[][] conn = {  { 0, 1, 0, 1, 0, 0, 0, 0, 1 },  // 0
                { 1, 0, 0, 0, 0, 0, 0, 1, 0 },  // 1
                { 0, 0, 0, 1, 0, 1, 0, 1, 0 },  // 2
                { 1, 0, 1, 0, 1, 0, 0, 0, 0 },  // 3
                { 0, 0, 0, 1, 0, 0, 0, 0, 1 },  // 4
                { 0, 0, 1, 0, 0, 0, 1, 0, 0 },  // 5
                { 0, 0, 0, 0, 0, 1, 0, 0, 0 },  // 6
                { 0, 1, 1, 0, 0, 0, 0, 0, 0 },  // 7
                { 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8

        AdjacencyMatrix G = new AdjacencyMatrix(9);
        G.setMatrix(conn);
        System.out.println(G.printMatrix(conn));
        System.out.println(BreadthFirstSearch(conn, 0));

    }

}
