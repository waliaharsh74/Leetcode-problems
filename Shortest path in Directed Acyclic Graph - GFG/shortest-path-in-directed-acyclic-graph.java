//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int v,int n, int[][] edges) {
		//Code here
	  int vis[]=new int[v];
	  ArrayList<ArrayList<Pair>> adj= new ArrayList<ArrayList<Pair>>();
	  
	  for(int i=0;i<v;i++){
	      adj.add(new ArrayList<Pair>());
	  }
	  
	  for(int i=0;i<n;i++){
	      int u=edges[i][0];
	      int vi=edges[i][1];
	      int wt=edges[i][2];
	      adj.get(u).add(new Pair(vi,wt));
	      
	      
	      
	  }
	  
	  ArrayDeque<Integer> st=new ArrayDeque<>();
	  
	  for(int i=0;i<v;i++){
	      if(vis[i]!=1)
	      {
	          topo(i,adj,vis,st);
	      }
	      
	  }
	  
	  int dis[]=new int[v];
	  int ans[]=new int[v];
	  Arrays.fill(dis,(int)(1e6));
	  dis[0]=0;
	  
	  while(!st.isEmpty()){
	      int cur=st.pop();
	      for(Pair neighbor:adj.get(cur)){
	          if(dis[cur]+neighbor.wt<dis[neighbor.v]){
	              dis[neighbor.v]=dis[cur]+neighbor.wt;
	          }
	      }
	  }
	  
	  for(int i=0;i<v;i++){
	      if(dis[i]==(int)(1e6)){
	          dis[i]=-1;
	      }
	  }
	  return dis;
	  
	  
	  
	  
	  
    }
    
    void topo(int src,ArrayList<ArrayList<Pair>> adj,int vis[],ArrayDeque<Integer> st){
        vis[src]=1;
        for(Pair neighbor:adj.get(src)){
            if(vis[neighbor.v]!=1){
                topo(neighbor.v,adj,vis,st);
            }
        }
        st.push(src);
    }

}

class Pair{
    
    int v;
    int wt;
    Pair(int v,int wt){
      
        this.v=v;
        this.wt=wt;
    }
    
    
}
