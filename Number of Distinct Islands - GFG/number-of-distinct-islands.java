//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class pair{
    int a;
    int b;
    pair(int a,int b){
        this.a=a;
        this.b=b;
    }
}
class Solution {

    int countDistinctIslands(int[][] a) {
        // Your Code here
        int n=a.length;
        int m=a[0].length;
        int vis[][]=new int[n][m];
        Set<ArrayList<String>> set=new HashSet<>();
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(a[i][j]==1 && vis[i][j]==0){
                    ArrayList<String> vec=new ArrayList<>();
                    dfs(i,j,i,j,a,vis,vec);
                    set.add(vec);
                    
                    
                    
                }
            }
        }
        return set.size();
        
    }
    
    String toString(int r,int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    
    void dfs(int row,int col,int rrow,int rcol,int[][]a,int vis[][],ArrayList<String> vec){
        vis[row][col]=1;
        vec.add(toString(row-rrow,col-rcol));
        int n=a.length;
        int m=a[0].length;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m &&
            a[nrow][ncol]==1 && vis[nrow][ncol]==0){
                dfs(nrow,ncol,rrow,rcol,a,vis,vec);
            }
        }
    }
}
