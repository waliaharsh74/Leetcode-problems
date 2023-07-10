//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int ans[][]=new int [n][m];
        boolean vis[][]=new boolean[n][m];
        ArrayDeque<Pair> q=new ArrayDeque<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        
        
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int r=cur.r;
            int c=cur.c;
            int s=cur.s;
            ans[r][c]=s;
            
            int delRow[]={-1,0,1,0};
            int delCol[]={0,1,0,-1};
            
            for(int i=0;i<4;i++){
                int nrow=r+delRow[i];
                int ncol=c+delCol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 && !vis[nrow][ncol]){
                    q.add(new Pair(nrow,ncol,s+1));
                    vis[nrow][ncol]=true;
                }
                
            }
        } 
        return ans;
    }
}
class Pair{
    int r;
    int c;
    int s;
    Pair(int r,int c,int s){
        this.r=r;
        this.c=c;
        this.s=s;
    }
}