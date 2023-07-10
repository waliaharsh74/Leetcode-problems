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
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        // int n=a.length;
        // int m=a[0].length;
        char ans[][]=new char [n][m];
        boolean vis[][]=new boolean[n][m];
        // ArrayDeque<Pair> q=new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            if(a[i][0]=='O' && !vis[i][0]){
                dfs(i,0,a,ans,vis);
            }
            if(a[i][m-1]=='O' && !vis[i][m-1]){
                dfs(i,m-1,a,ans,vis);
            }
            
        }
        for(int i=0;i<m;i++){
            if(a[0][i]=='O' && !vis[0][i]){
                dfs(0,i,a,ans,vis);
            }
            if(a[n-1][i]=='O'&& !vis[n-1][i]){
                dfs(n-1,i,a,ans,vis);
            }
            
        }
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && a[i][j]=='O'){
                    a[i][j]='X';
                }
                
            }
        }
        
        return a;
        
    }
    
    static void  dfs(int r, int c, char a[][],char ans[][],boolean vis[][]){
        int n=a.length;
        vis[r][c]=true;
        int m=a[0].length;
        int delRow[]={-1,0,1,0};
        int delCol[]={0,1,0,-1};
            
        for(int i=0;i<4;i++){
            int nrow=r+delRow[i];
            int ncol=c+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && a[nrow][ncol]=='O' && !vis[nrow][ncol]){
                dfs(nrow,ncol,a,ans,vis);
                
            }
        }
    }           
}