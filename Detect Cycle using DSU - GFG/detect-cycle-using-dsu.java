//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            int ans = obj.detectCycle(V, adj);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
     int find(int parent[], int i)
    {
        if (parent[i] == i)
            return i;
        return find(parent, parent[i]);
    }
 
    // A utility function to do union of two subsets
    void Union(int parent[], int x, int y)
    {
        parent[x] = y;
    }
    //Function to detect cycle using DSU in an undirected graph.
    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean vis[] = new boolean[V];
        for(int i = 0; i<V; i++) {
			if(!vis[i]) {
				if(isCyclePresent(i, vis, -1,adj)) {
					return 1;
				// 	break;
				}
			}
		} 
		return 0;
        
    }
    public boolean isCyclePresent(int src, boolean vis[], int parent,ArrayList<ArrayList<Integer>> adj) {
		vis[src] = true;
		
		for(Integer neighbor: adj.get(src)) {
			if(!vis[neighbor]) {				
				if(isCyclePresent(neighbor, vis, src,adj)) return true;
			} else if(neighbor != parent){
				return true;
			}
		}
		
		return false;
	}
}