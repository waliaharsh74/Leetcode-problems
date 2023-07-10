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
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int src=0;
        boolean vis[]=new boolean[v];
        // vis[src]=true;
        for(int i = 0; i<v; i++) {
			if(!vis[i]) {
				if(isCyclePresent(i, vis, -1,adj)) {
					return true;
				
				}
			}
		}
		return false;
    }
     boolean isCyclePresent(int src, boolean vis[], int parent,ArrayList<ArrayList<Integer>> a) {
		vis[src] = true;
		
		for(Integer neighbor: a.get(src)) {
			if(!vis[neighbor]) {				
				if(isCyclePresent(neighbor, vis, src,a)) return true;
			} else if(neighbor != parent){
				return true;
			}
		}
		
		return false;
	}
}