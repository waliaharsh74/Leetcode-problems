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
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        if(V==0)return false;
        // Code here
        boolean vis[]=new boolean[V];
        for (int i = 0; i < V; i++)
            vis[i] = false;
        for (int u = 0; u < V; u++) {
 
            // Don't recur for u if already visited
            if (!vis[u])
                if (isCyclePresent(u,adj, vis, -1))
                    return true;
        }
 
        return false;
        
        
    }
    boolean isCyclePresent(int src,ArrayList<ArrayList<Integer>> adj,boolean vis[],int parent){
        vis[src]=true;
        for(Integer neighbor:adj.get(src)){
            if(!vis[neighbor]){
                if(isCyclePresent(neighbor,adj,vis,src)){ 
                    
                    return true;
                }    
                
            }
            else if(neighbor!=parent){
                return true;
            }
        }
        return false;
        
    }
    
}