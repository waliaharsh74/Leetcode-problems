//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean vis[]=new boolean [v];
        boolean pathvis[]=new boolean [v];
        
        for(int i=0;i<v;i++){
            if( dfs(i,adj,vis,pathvis)==true)
                return true;
        }
        return false;
    }
    boolean dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean vis[],boolean pathvis[]){
        vis[src]=true;
        pathvis[src]=true;
        
        for(Integer neighbor:adj.get(src)){
            if(!vis[neighbor]){
                if(dfs(neighbor,adj,vis,pathvis)==true)
                    return true;
            }
            else if(pathvis[neighbor]){
                    return true;
            }
            
            
        }
        pathvis[src]=false;
        return false;
    }
}