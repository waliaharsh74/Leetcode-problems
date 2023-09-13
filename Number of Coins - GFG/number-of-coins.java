//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{

	public int minCoins(int coins[], int n, int V) 
	{ 
	    // Your code goes here
	    int dp[][]=new int[n][V+1];
	    for(int j=0;j<=V;j++){
	        
    	    if(j%coins[0]==0){
    	        dp[0][j]=j/coins[0];
    	    }
    	    else{
    	        dp[0][j]=(int)1e9;
    	    }
	    }
	    for(int i=1;i<n;i++){
	        for(int j=0;j<=V;j++){
	            int p=dp[i-1][j];
	            int k=(int)1e9;
	            int l=(int)1e9;
	            if(coins[i]<=j){
	               // k=1+dp[i-1][j-coins[i]];
	                l=1+dp[i][j-coins[i]];
	            }
	            dp[i][j]=Math.min(l,p);
	        }
	            
	    }
	    return (dp[n-1][V]<(int)1e9)?dp[n-1][V]:-1;
	} 
}