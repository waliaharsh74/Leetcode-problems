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

    int numberOfEnclaves(int[][] a) {

        // Your code here
        int n=a.length;
        int m=a[0].length;
        boolean vis[][]=new boolean[n][m];
        // ArrayDeque<Pair> q=new ArrayDeque<>();
        int cnt=0;
        
        for(int i=0;i<n;i++){
            if(a[i][0]==1 && !vis[i][0]){
                dfs(i,0,a,vis);
            }
            if(a[i][m-1]==1 && !vis[i][m-1]){
                dfs(i,m-1,a,vis);
            }
            
        }
        for(int i=0;i<m;i++){
            if(a[0][i]==1 && !vis[0][i]){
                dfs(0,i,a,vis);
            }
            if(a[n-1][i]==1 && !vis[n-1][i]){
                dfs(n-1,i,a,vis);
            }
            
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && a[i][j]==1){
                    cnt++;
                }
                
            }
        }
        
        return cnt;
    }
    
    void  dfs(int r, int c, int a[][],boolean vis[][]){
        int n=a.length;
        vis[r][c]=true;
        int m=a[0].length;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
            
        for(int i=0;i<4;i++){
            int nrow=r+delRow[i];
            int ncol=c+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && a[nrow][ncol]== 1 && !vis[nrow][ncol]){
                dfs(nrow,ncol,a,vis);
                
            }
        }
    }       
}