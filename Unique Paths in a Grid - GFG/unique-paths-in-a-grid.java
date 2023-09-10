//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            
            int [][] grid = new int[n][m];
            for(int i=0; i<n; i++)
            {
                String S1[] = read.readLine().split(" ");
                for(int j=0; j<m; j++)
                {
                    grid[i][j] = Integer.parseInt(S1[j]);
                }
            }

            Solution ob = new Solution();
            System.out.println(ob.uniquePaths(n,m,grid));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int uniquePaths(int m, int n, int[][] grid) {
        // code here
        int dp[][]=new int[m+1][n+1];
        // dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0 && grid[i][j]==1)dp[i][j]=1;
                else{
                int up=0;
                int down=0;
                if(i>0)up=dp[i-1][j];
                if(j>0)down=dp[i][j-1];
                if(grid[i][j]==1)
                    dp[i][j]=(up+down)%1000000007;
                }
                
                
            }
            // System.out.println();
        }

        return dp[m-1][n-1];
    }
};