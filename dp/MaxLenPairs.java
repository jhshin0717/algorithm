
/*
You are given n pairs of numbers. In every pair, 
the first number is always smaller than the second number. 
A pair (c, d) can follow another pair (a, b) if b < c. 
Chain of pairs can be formed in this fashion. 
Find the longest chain which can be formed from a given set of pairs.

For example, if the given pairs are {{5, 24}, {39, 60}, {15, 28}, 
{27, 40}, {50, 90} }, then the longest chain that can be formed is 
of length 3, and the chain is {{5, 24}, {27, 40}, {50, 90}}

*State
State(n) = count

*Expression

State(n) :
    > State(n-1)+1 if (pair[n].first > pair[n-1].last)
    > for i = n-2 to 0 : if (pair[n].first > pair[i].last) Max(State(i)+1, State(n-1)) 
*/
import java.util.*;
import java.lang.*;
import java.io.*;

class MaxLenPairs {
    static int Max = 5;

    static class Pair {
        int first;
        int last;

        Pair(int a, int b) {
            first = a;
            last = b;
        }
    }

    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int getPairs(int n) {
        Pair[] pairs = new Pair[] { new Pair(5, 24), new Pair(15, 25), new Pair(27, 40), new Pair(50, 60)};
        int[] dp = new int[n];
        for (int k = 0; k < n; k++) {
            dp[k] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (pairs[i].first > pairs[i - 1].last) {
                dp[i] = dp[i - 1] + 1;
            } else {
                for (int j = i - 2; j >= 0; j--) {
                    if (pairs[i].first > pairs[j].last) {
                        dp[i] = max(dp[i] + 1, dp[j]);
                        break;
                    }
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        //code
        System.out.println("getPairs: " + getPairs(4));

    }
}
