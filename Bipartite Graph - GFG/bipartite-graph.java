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
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
    public boolean isBipartite(int v, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        boolean vis[]=new boolean [v];
        int color[]=new int[v];
        for(int i=0;i<v;i++){
            color[i]=-1;
        }
        int src=0;
        
        for(int i=0;i<v;i++){
            if(color[i]==-1){
                if(bfs(i,adj,color)==false)return false;
            }
        }
        return true;
        
        
        
    }
    
    boolean bfs(int src, ArrayList<ArrayList<Integer>>adj,int color[]){
        ArrayDeque<Integer>q =new ArrayDeque<>();
        q.add(src);
        color[src]=0;
        while(!q.isEmpty()){
            int cur=q.poll();
            
            for(Integer neighbor:adj.get(cur)){
                if(color[neighbor]==-1){
                    color[neighbor]=1-color[cur];
                    q.add(neighbor);
                }
                else{
                    if(color[neighbor]==color[cur]){
                        return false;
                    }
                }
            }
            
        }
        
        
        return true;
    }
    
    
}