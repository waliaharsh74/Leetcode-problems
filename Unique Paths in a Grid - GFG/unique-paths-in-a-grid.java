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
    static int uniquePaths(int m, int n, int[][] obstacleGrid) {
        // code here
    //   return countWaysUtil(m-1,n-1,dp);
        int mod=1000000007;
       int[][] path = new int[m][n];

	for (int i = 0; i < m; i++) {
		if (obstacleGrid[i][0] == 0)  {
			path[i][0] = 0;
			//on the first column, if there is an obstacle, the rest are blocked. 
			//no need to continue.
			break;  
		} else
			path[i][0] = 1;
	}
	
	for (int j = 0; j < n; j++) {
		if (obstacleGrid[0][j] == 0)  {
			path[0][j] = 0;
			//First row, once obstacle found, the rest are blocked.
			break; 
		} else
			path[0][j] = 1;
	}
	
	for (int i = 1; i < m; i++) {
		for (int j = 1; j < n; j++) {
			if (obstacleGrid[i][j] == 0) 
				path[i][j] = 0;
			else
				path[i][j] = (path[i-1][j] + path[i][j-1])%mod;
		}
	}
	return path[m-1][n-1];
    
        
        
    }
    

}