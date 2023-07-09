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

class Pair{
    int r, c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}
class Solution {
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        boolean vis[][]=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'&&!vis[i][j]){
                    count++;
                    bfs(grid,i,j,vis);
                }
            }
        }
        return count;
        // Code here
    }
    void bfs(char[][] grid,int row,int col,boolean vis[][]){
        int n=grid.length;
        int m=grid[0].length;
        ArrayDeque<Pair> q=new ArrayDeque<>();
        q.add(new Pair(row,col));
        vis[row][col]=true;
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int r=cur.r;
            int c=cur.c;
            for(int dr=-1;dr<=1;dr++){
                for(int dc=-1;dc<=1;dc++){
                    int nrow=r+dr;
                    int ncol=c+dc;
                    
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1'&& !vis[nrow][ncol]){
                        q.add(new Pair(nrow,ncol));
                        vis[nrow][ncol]=true;
                        
                    }
                }
            }
        }
    }
}