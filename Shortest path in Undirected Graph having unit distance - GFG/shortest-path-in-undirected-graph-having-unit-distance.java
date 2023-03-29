//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        int []dis=new int[n];
        boolean vis[]=new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(); 
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>()); 
        }
        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]); 
            adj.get(edges[i][1]).add(edges[i][0]); 
        }
        Arrays.fill(dis,-1);
        
         
            bfs(adj,n,m,src,vis,dis);
        return dis;
        
    }
    void bfs(ArrayList<ArrayList<Integer>> adj,int n,int m ,int src,boolean vis[],int []dis){
        Queue<Integer> q=new ArrayDeque<>();
        q.add(src);
        dis[src]=0;
        
        vis[src]=true;
        
        
        while(!q.isEmpty()){
            int cur=q.poll();
            for(Integer neighbor:adj.get(cur)){
                if(!vis[neighbor] ){
                    q.add(neighbor);
                    dis[neighbor]=dis[cur]+1;
                    // System.out.println(cur+" "+neighbor+" "+dis[neighbor]);
                    vis[neighbor]=true;
                }
            }
        }
        
    }
}