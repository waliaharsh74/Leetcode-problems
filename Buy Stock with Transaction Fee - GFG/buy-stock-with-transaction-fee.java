//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            int fee=sc.nextInt();
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N,fee);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int N, int fee){
        // Code here
        int n=prices.length;
        long dp[][]=new long [n+1][2];
        for(int i=n-1;i>=0;i--){
            for(int b=0;b<=1;b++){
                if(b==1){
                    dp[i][b]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    dp[i][b]=Math.max(prices[i]-fee+dp[i+1][1],dp[i+1][0]);
                }
            }
            
        }
        return dp[0][1];
    }
}