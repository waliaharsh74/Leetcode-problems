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

    List<Integer> eventualSafeNodes(int v, List<List<Integer>> adj) {

        // Your code here
        boolean vis[]=new boolean[v];
        boolean pathvis[]=new boolean[v];
        boolean safe[]=new boolean[v];
        List<Integer> ans= new ArrayList<Integer>(); 
        
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(i,adj,vis,pathvis,safe);
            }
        }
        
        for(int i=0;i<v;i++){
            if(safe[i]){
                ans.add(i);
            }
        }
        return ans;
    }
    
    boolean dfs(int src,List<List<Integer>> adj,boolean vis[],boolean pathvis[],boolean safe[]){
        vis[src]=true;
        pathvis[src]=true;
        safe[src]=false;
        
        for(Integer neighbor:adj.get(src)){
            if(!vis[neighbor]){
                if(dfs(neighbor,adj,vis,pathvis,safe)==true)return true;
                
                
            }
            else if(pathvis[neighbor]){
                    return true;
            }
        }
        pathvis[src]=false;
        safe[src]=true;
        return false;
        
    }
    
}
