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
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj2=new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<v;i++) {
            adj2.add(new ArrayList<Integer>()); 
        }
        
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                if(adj.get(i).get(j)==1){
                    adj2.get(i).add(j);
                    adj2.get(j).add(i);
                }
            }
        }
        
        int cnt=0;
        boolean vis[]=new boolean[v];
        for(int i=0;i<v;i++){
            if(!vis[i]){
                dfs(i,adj2,vis);
                cnt++;
            }
        }
        return cnt;
        
    }
    static void dfs(int src,ArrayList<ArrayList<Integer>> adj,boolean vis[]){
        vis[src]=true;
        for(Integer neighbor:adj.get(src)){
            if(!vis[neighbor]){
                dfs(neighbor,adj,vis);
            }
        }
    }
};