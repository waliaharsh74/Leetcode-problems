//{ Driver Code Starts
//Initial Template for Java

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
            String S = br.readLine().trim();
            String[] S1 = S.split(" ");
            int n = Integer.parseInt(S1[0]);
            int amount  = Integer.parseInt(S1[1]);
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.MinCoin(nums, amount);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int MinCoin(int[] arr, int sum)
    {
        // Code here
        int n=arr.length;
        int dp[][]=new int[n][sum+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
            
        }
        
        int ans= mem(n-1,arr,sum,dp);
        if(ans>=(int)1e8){
            return -1;
        }
        return ans;
        
        
        
    }
    int mem(int i,int arr[],int sum,int dp[][]){
        if(i==0){
            if(sum%arr[i]==0){
                return sum/arr[i];
            }
            else{
                return (int)1e8;
            }
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int notake=0+mem(i-1,arr,sum,dp);
        int take=(int)1e8;
        if(arr[i]<=sum){
            take=1+mem(i,arr,sum-arr[i],dp);
        }
        return dp[i][sum]=Math.min(take,notake);
    }
}