//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int MinimumEffort(int heights[][]) {
        int n= heights.length;
        int m=heights[0].length;
        PriorityQueue<tuple> pq=new PriorityQueue<>((x,y)->x.distance-y.distance);
        int dist[][]=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        pq.add(new tuple(0,0,0));
        
        int dr[] = {-1, 0, 1, 0}; 
        int dc[] = {0, 1, 0, -1}; 
        
        while(!pq.isEmpty()){
            tuple cur=pq.poll();
            int row=cur.row;
            int col=cur.col;
            int distance=cur.distance;
            
            if(row==n-1 && col==m-1)return distance;
            
            for(int i = 0;i<4;i++) {
                int newr = row + dr[i]; 
                int newc = col + dc[i];
                
                
                if(newr>=0 && newr<n && newc>=0 && newc<m  ){
                    int diff=Math.abs(heights[row][col]-heights[newr][newc]);
                    int newEffort=Math.max(distance,diff);
                    
                    if(newEffort<dist[newr][newc]){
                        dist[newr][newc]=newEffort;
                        
                        pq.add(new tuple(newEffort,newr,newc));
                        
                    }
                }
                
            }
            
        }
        return 0;
        
    }
}
class tuple{
    int distance;
    int row;
    int col;
    tuple(int distance,int row,int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}