//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static char[][] fill(int n, int m,char mat [][])
    {
        // code here
        int[][] vis=new int[n][m];
        for(int j = 0 ; j<m;j++) {
            // check for unvisited Os in the boundary rws
            // first row 
            if(vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, n, m); 
            }
            
            // last row 
            if(vis[n-1][j] == 0 && mat[n-1][j] == 'O') {
                dfs(n-1,j,vis,mat, n, m); 
            }
        }
        
        for(int i = 0;i<n;i++) {
            // check for unvisited Os in the boundary columns
            // first column 
            if(vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, n, m); 
            }
            
            // last column
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat, n, m); 
            }
        }
        
        // if unvisited O then convert to X
        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(vis[i][j] == 0 && mat[i][j] == 'O') 
                    mat[i][j] = 'X'; 
            }
        }
        
        return mat;     
        
        
    }
    static void dfs(int row, int col, int[][] vis,char a[][],int n, int m){
        vis[row][col]=1;
        int drow[] ={-1,0,1,0};
        int dcol[] ={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n&& ncol<m &&
            a[nrow][ncol]=='O' &&vis[nrow][ncol]==0)
            {
             dfs(nrow,ncol,vis,a,n,m);   
            }
            
        }
        
        
    }
}