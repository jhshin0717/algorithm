
import java.util.*;
import java.lang.*;
import java.io.*;

public class Dijkstra {

    static class Queue {
        int front;
        int rear;
        int[] queue;

        Queue(int maxSize) {
            queue = new int[maxSize + 1];
        }

        void enqueue(int value) {
            //System.out.println("value: " + value + ", rear: " + rear);        
            queue[rear++] = value;
        }

        int dequeue() {
            return queue[front++];
        }

        int size() {
            return rear - front;
        }

    }

    private static int getMinPath(int[][] matrix, int n) {
        Queue queue = new Queue(n);
        boolean[] visited = new boolean[n + 1];
        int[] cost = new int[n + 1];

        int v = 0;
        queue.enqueue(0);
        visited[0] = true;
        while (queue.size() > 0) {
            v = queue.dequeue();
            for (int j = 0; j < n; j++) {
                if (matrix[v][j] > 0 && !visited[j]) {
                    if (cost[j] == 0 || cost[j] > matrix[v][j] + cost[v]) {
                         queue.enqueue(j);
                        cost[j] =  matrix[v][j] + cost[v];
                        System.out.println(v + " to " + j + ", cost: " + cost[j] + " selected");
                     
                    } else {
                        System.out.println(v + " to " + j + ", cost: " + cost[j] + " deselected");
                    }
                }
            }
            for (int k = 0; k < n; k++) {
                if (cost[k] > 0) {
                    visited[k] = true;
                }
            }
        }

        return cost[n];
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

        System.out.println("getMinPath: " + getMinPath(graph, 9));

    }
}
