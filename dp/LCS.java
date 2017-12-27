/* A Naive recursive implementation of LCS problem in java*/
public class LCS {

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs(char[] X, char[] Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (X[m - 1] == Y[n - 1])
            return 1 + lcs(X, Y, m - 1, n - 1);
        else
            return max(lcs(X, Y, m, n - 1), lcs(X, Y, m - 1, n));
    }

    int lcsDp(char[] x, char[] y, int m, int n) {
        int result = 0;
        int lcs[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (x[i - 1] == y[i - 1]) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                } else {
                    lcs[i][j] = max(lcs[i][j - 1], lcs[i - 1][j]);
                }
                System.out.println("i:" + i + ", j:" + j + ", lcs:" + lcs[i][j]);
            }
        }

        return result;

    }

    /* Utility function to get max of 2 integers */
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static void main(String[] args) {
        LCS lcs = new LCS();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " + lcs.lcsDp(X, Y, m, n));
    }

}