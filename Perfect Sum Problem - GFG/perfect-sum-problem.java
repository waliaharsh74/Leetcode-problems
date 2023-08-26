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
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends

// import java.util.*;
class Solution{

	public int perfectSum(int num[],int l, int k) 
	{ 
	    // Your code goes here
	int n = num.length;
	Arrays.sort(num);
    for (int i = 0; i < num.length / 2; i++) {
    int temp = num[i];
    num[i] = num[num.length - 1 - i];
    num[num.length - 1 - i] = temp;
}
    int mod=1000000007;


    int[][] dp=new int[n][k+1];
    
    for(int i=0; i<n; i++){
        dp[i][0] = 1;
    }
    
    if(num[0]<=k)
        dp[0][num[0]] = 1;
    
    for(int ind = 1; ind<n; ind++){
        for(int target= 1; target<=k; target++){
            
            int notTaken = dp[ind-1][target];
    
            int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];
        
            dp[ind][target]= (notTaken + taken)%mod;
        }
    }
    
    return dp[n-1][k];
    }
     int mem(int i,int arr[],int sum,int dp[][]){
        int n=arr.length;
        if(i==0){
            if(arr[i]==sum)
                return 1;
            else{
                return 0;
            }    
        }
        if(sum==0)return 1;
        if(dp[i][sum]!=-1)return dp[i][sum];
        int pick=mem(i-1,arr,sum,dp);
        int notPick=0;
        if(arr[i]<=sum){
            notPick=mem(i-1,arr,sum-arr[i],dp);
        }
        return dp[i][sum]=pick+notPick;
    }   
}