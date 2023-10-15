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
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int shortestPath(int[][] grid, int[] s, int[] dt) {

        int n=grid.length;
        int m=grid[0].length;
        if(s[0]==dt[0]&& s[1]==dt[1])
            return 0;
            
        int dis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],(int)1e9);
            
        }
        
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->{
            return x.dis-y.dis;
        });
        pq.add(new Pair(0,s[0],s[1]));
        dis[s[0]][s[1]]=0;
        while(!pq.isEmpty()){
            Pair cur=pq.poll();
            int d=cur.dis;
            int r=cur.r;
            int c=cur.c;
            int dr[]={-1,0,1,0};
            int dc[]={0,-1,0,1};
            
            for(int i=0;i<4;i++){
                int nr=dr[i]+r;
                int nc=dc[i]+c;
                
                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1 && dis[nr][nc]>1+d){
                    dis[nr][nc]=1+d;
                    pq.add(new Pair(dis[nr][nc],nr,nc));
                }
            }
            
        }
        if(dis[dt[0]][dt[1]]==(int)1e9){
            return -1;
        }
        return dis[dt[0]][dt[1]];
        
    }
}
class Pair{
    int dis;
    int r;
    int c;
    Pair(int dis,int r,int c){
        this.dis=dis;
        this.r=r;
        this.c=c;
    }
}
