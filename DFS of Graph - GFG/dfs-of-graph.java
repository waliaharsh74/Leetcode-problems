//{ Driver Code Starts
// Initial Template for Java
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
            ArrayList<ArrayList<Integer>> adj =
                new ArrayList<ArrayList<Integer>>();
            for (int i = 0; i < V; i++) adj.add(new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer> ans = obj.dfsOfGraph(V, adj);
            for (int i = 0; i < ans.size(); i++)
                System.out.print(ans.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans=new ArrayList<Integer>();
        boolean vis[]=new boolean[v];
        int src=0;
        // ans.add(src?
        dfs(adj,src,vis,ans);
        // System.out.println(adj.get(0).get(0));
        // for(Integer:neighbor:a.get(src)){
        //     if(!vis[neighbor]){
        //         return 
        //     }
        // }
        return ans;
        
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int src,boolean vis[],ArrayList<Integer> ans){
        // int src=0;
        ans.add(src);
        vis[src]=true;
        // System.out.println(adj.get(0).get(0));
        for(Integer neighbor:adj.get(src)){
            if(!vis[neighbor]){
                 dfs(adj,neighbor,vis,ans);
            }
        }
    }
}