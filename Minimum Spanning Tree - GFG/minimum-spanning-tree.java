//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    ArrayList<ArrayList<pair>>adj=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	        
	    }
	    for(int i=0;i<E;i++){
	        int u=edges[i][0];
	        int v=edges[i][1];
	        int wt=edges[i][2];
	        adj.get(u).add(new pair(v,wt));
	        adj.get(v).add(new pair(u,wt));
	        
	        
	    }
	    int vis[]=new int[V];
	    
	    PriorityQueue<tuple> pq=new PriorityQueue<>((x,y)->{
	        return x.wt-y.wt;
	    });
	    pq.add(new tuple(-1,0,0));
	    int sum=0;
	    while(!pq.isEmpty()){
	        tuple cur=pq.poll();
	        int p=cur.u;
	        int v=cur.v;
	        int wt=cur.wt;
	         if (vis[v] == 1) continue;
	        vis[v]=1;
	        sum+=wt;
	        
	        for(pair it:adj.get(v)){
	            if(vis[it.u]==0){
	                pq.add(new tuple(v,it.u,it.wt));
	            }
	        }
	        
	        
	    }
	    return sum;
	    
	    
	    
	    
	    
	    
	}
}
class pair{
    int u;
    int wt;
    // int wt;
    pair(int u,int wt){
        this.u=u;
        this.wt=wt;
        // this.wt=wt;
    }
}
class tuple{
    int u;
    int v;
    int wt;
    tuple(int u,int v,int wt){
        this.u=u;
        this.v=v;
        this.wt=wt;
    }
}