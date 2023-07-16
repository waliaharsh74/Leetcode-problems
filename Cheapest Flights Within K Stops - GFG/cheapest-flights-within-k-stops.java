//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int arr[][],int src,int dst,int k) {
        // Code here
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)1e9;
        }
        ArrayList<ArrayList<Pair>> adj =new ArrayList<ArrayList<Pair>>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][0]).add(new Pair(arr[i][1],arr[i][2]));
        }
        
        dist[src]=0;
        Queue<Tuple>q=new LinkedList<>();
        q.add(new Tuple(0,src,0));
        
        while(!q.isEmpty()){
            Tuple cur=q.poll();
            int stops=cur.first;
            int v=cur.second;
            int cost=cur.third;
            
            if(stops>k)continue;
            for(Pair neighbor:adj.get(v)){
                if(dist[neighbor.val]>cost+neighbor.wt){
                    dist[neighbor.val]=cost+neighbor.wt;
                    q.add(new Tuple(stops + 1, neighbor.val, dist[neighbor.val]));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1; 
        return dist[dst]; 
        
    }
    
    
}

class Tuple {
    int first, second, third; 
    Tuple(int first, int second, int third) {
        this.first = first; 
        this.second = second;
        this.third = third; 
    }
}

class Pair{
    int val;
    int wt;
    Pair(int val,int wt){
        this.val=val;
        this.wt=wt;
    }
}