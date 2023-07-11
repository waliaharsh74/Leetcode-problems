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
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        List<Integer> ans=new ArrayList<>();
        boolean vis[]=new boolean[V];
        boolean pathVis[]=new boolean[V];
        int check[]=new int[V];
        for(int i=0;i<V;i++)
        {
            if(!vis[i]){
                dfs(i,adj,vis,pathVis,check);
            }
        }
        
        for(int i=0;i<V;i++)
        {
            if(check[i]==1){
                ans.add(i);
            }
        }
        return ans;
        
    }
    boolean dfs(int src,List<List<Integer>> adj,boolean vis[],boolean pathVis[],int check[]){
        vis[src]=true;
        pathVis[src]=true;
        check[src]=0;
        for(Integer neighbor:adj.get(src)){
            if(!vis[neighbor]){
                if(dfs(neighbor,adj,vis,pathVis,check)) return true;
            }
            else if(pathVis[neighbor]) return true;
        }
        pathVis[src]=false;
        check[src]=1;
        return false;
    }
}
