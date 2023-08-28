//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String line1[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(line1[0]);
            int W = Integer.parseInt(line1[1]);
            String line2[] = in.readLine().trim().split("\\s+");
            int val[] = new int[N];
            for(int i = 0;i < N;i++)
                val[i] = Integer.parseInt(line2[i]);
            String line3[] = in.readLine().trim().split("\\s+");
            int wt[] = new int[N];
            for(int i = 0;i < N;i++)
                wt[i] = Integer.parseInt(line3[i]);
                
            Solution ob = new Solution();
            System.out.println(ob.knapSack(N, W, val, wt));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int knapSack(int n, int W, int val[], int wt[])
    {
        // code here
        int dp[][]=new int[n][W+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return mem(n-1,W,val,wt,dp);
    }
    static int mem(int i, int W, int val[], int wt[],int dp[][]){
        // if(i==0){
        //     // if(W%wt[i]==0){
        //     //     return (W/wt[i])*val[i];
        //     // }
            
        //     if(W>=wt[i]){
        //         return val[i];
        //     }
        //     else{
        //         return 0;
        //     }
            
        // }
        
        if(i == 0){
        return ((int)(W/wt[0])) * val[0];
    }
        if(dp[i][W]!=-1){
            return dp[i][W];
        }
        int notake=mem(i-1,W,val,wt,dp);
        int take=0;
        if(wt[i]<=W){
            take=val[i]+mem(i,W-wt[i],val,wt,dp);
        }
        return dp[i][W]=Math.max(take,notake);
        
        
    }
}