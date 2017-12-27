
/*
Given a cost matrix cost[][] and a position (m, n) in cost[][], 
write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). 
Each cell of the matrix represents a cost to traverse through that cell. 
Total cost of a path to reach (m, n) is sum of all the costs on that path 
(including both source and destination). You can only traverse down, 
right and diagonally lower cells from a given cell, 
i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) 
can be traversed. You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?

state(m, n)
Constraints:
1<=T<=20
2<=N<=20
1<=Matrix[i][j]<=1000 (for all 1<=i<=N && 1<=j<=N)

Example:

Input:
1
2
348 391 618 193

*Recursive(dfs)
*DP

State(m, n) = minCost
State(m, n) = Min(State(m-1, n), State(m, n-1), State(m-1, n-1)) + cost[m, n]
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class MinCostPath {
    static int[][] matrix = new int[20][20];

    int minCost(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return matrix[0][0];
        }
        return min(minCost(m - 1, n), minCost(m, n - 1), minCost(m - 1, n - 1)) + matrix[m][n];
    }

    static int minCostDP(int m, int n) {
        int[][] minCost = new int[m + 1][n + 1];

        minCost[0][0] = matrix[0][0];
        for (int i = 1; i <= m; i++) {
            minCost[i][0] = minCost[i - 1][0] + matrix[i][0];
        }

        for (int j = 1; j <= n; j++) {
            minCost[0][j] = minCost[0][j - 1] + matrix[0][j];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                minCost[i][j] = min(minCost[i - 1][j], minCost[i][j - 1], minCost[i - 1][j - 1]) + matrix[i][j];
            }
        }
        return minCost[m][n];
    }

    private static int min(int x, int y, int z) {
        if (x < y)
            return (x < z) ? x : z;
        else
            return (y < z) ? y : z;
    }

    public static void main(String[] args) {
        //code
        int cost[][] = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };
        matrix = cost;

        System.out.println("minimum cost to reach (2,2) = " + minCostDP(3 - 1, 3 - 1));
    }
}
