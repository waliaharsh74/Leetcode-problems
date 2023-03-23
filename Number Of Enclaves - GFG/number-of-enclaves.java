//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] mat) {
        

        // Your code here
        int n=mat.length;
        int m=mat[0].length;
        int ans=0;
        int[][] vis=new int[n][m];
        for(int j = 0 ; j<m;j++) {
            // check for unvisited Os in the boundary rws
            // first row 
            if(vis[0][j] == 0 && mat[0][j] == 1) {
                dfs(0, j, vis, mat, n, m); 
            }
            
            // last row 
            if(vis[n-1][j] == 0 && mat[n-1][j] == 1) {
                dfs(n-1,j,vis,mat, n, m); 
            }
        }
        
        for(int i = 0;i<n;i++) {
            // check for unvisited Os in the boundary columns
            // first column 
            if(vis[i][0] == 0 && mat[i][0] == 1) {
                dfs(i, 0, vis, mat, n, m); 
            }
            
            // last column
            if(vis[i][m-1] == 0 && mat[i][m-1] == 1) {
                dfs(i, m-1, vis, mat, n, m); 
            }
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==1 && vis[i][j]==0){
                    // System.out.print(vis[i][j]+" ");
                    ans++;
                }
            }
            // System.out.println();
        }
        return ans;
        
        
    }
    void dfs(int row, int col, int[][] vis,int a[][],int n, int m){
        vis[row][col]=1;
        int drow[] ={-1,0,1,0};
        int dcol[] ={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n&& ncol<m &&
            a[nrow][ncol]==1 &&vis[nrow][ncol]==0)
            {
             dfs(nrow,ncol,vis,a,n,m);   
            }
            
        }
        
        
    }
}