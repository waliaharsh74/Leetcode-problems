//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        
        // Your code here
        // ArrayList<ArrayList<>> adj=new ArrayList<>();
        int mod=100000; 
        if(start==end)return 0;
        PriorityQueue<pair>pq=new PriorityQueue<>((x,y)->x.st-y.st);
        int dist[]=new int[100000];
        for(int i=0;i<100000 ;i++){
            dist[i]=(int )(1e9);
        }
        dist[start]=0;
        pq.add(new pair(start,0));
        while(!pq.isEmpty()){
            pair cur=pq.poll();
            int st=cur.st;
            int node=cur.node;
            for(int i=0;i<arr.length;i++){
                // if
                int mul=(node*arr[i])%mod;
                if(dist[mul]>st+1){
                    dist[mul]=st+1;
                    if(mul==end){
                    return st+1;
                    }
                    pq.add(new pair(mul,st+1));
                }
                
                
            }
        }
        return -1;
    }
}
class pair{
    int st;
    int node;
    pair(int node,int st){
        this.node=node;
        this.st=st;
    }
}
