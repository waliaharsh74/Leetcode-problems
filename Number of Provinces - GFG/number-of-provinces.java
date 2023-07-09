//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    
    public  void dfs(int node, 
       ArrayList<ArrayList<Integer>> adjLs , 
       int vis[]) {
        vis[node] = 1; 
        for(Integer it: adjLs.get(node)) {
            if(vis[it] == 0) {
                dfs(it, adjLs, vis); 
            }
        }
    }
    
    int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<ArrayList<Integer>>(); 
        for(int i = 0;i<V;i++) {
            adjLs.add(new ArrayList<Integer>()); 
        }
        
        // to change adjacency matrix to list 
        for(int i = 0;i<V;i++) {
            for(int j = 0;j<V;j++) {
                // self nodes are not considered 
                if(adj.get(i).get(j) == 1 && i != j) {
                    adjLs.get(i).add(j); 
                    adjLs.get(j).add(i); 
                }
            }
        }
        int vis[] = new int[V]; 
        int cnt = 0; 
        for(int i = 0;i<V;i++) {
            if(vis[i] == 0) {
               cnt++;
               dfs(i, adjLs, vis); 
            }
        }
        return cnt; 
    }
};