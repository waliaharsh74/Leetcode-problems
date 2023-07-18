//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int cnt=0;
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    dfs(i,j,grid,vis);
                    cnt++;
                }
            }
        }
        return cnt;
        
        
    }
    void dfs(int row,int col,char[][] grid,boolean vis[][]){
        vis[row][col]=true;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int delr=row+i;
                int delc=col+j;
                
                if(delr>=0 && delc >=0 && delr<n && delc<m && !vis[delr][delc] && grid[delr][delc]=='1'){
                    dfs(delr,delc,grid,vis);
                }
            }
        }
    }
}