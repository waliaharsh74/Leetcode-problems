//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int nums[])
    {
        // code here
    int sum=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0)return 0;
        sum=sum/2;
        int dp[][]=new int[n][sum+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        // code here
        if( mem(nums,n-1,sum,dp)){
            return 1;
        }
        else{
            
            return 0;
        }
    }
    static  Boolean mem(int arr[],int i,int sum,int dp[][]){
        if(sum==0)return true;
        if(i==0)return arr[i]==sum;
        
    if(dp[i][sum]!=-1)
        return dp[i][sum]==0?false:true;
        boolean notTake=mem(arr,i-1,sum,dp);
        boolean take=false;
        if(arr[i]<=sum){
            take=mem(arr,i-1,sum-arr[i],dp);
            dp[i][sum]=notTake||take?1:0;
        }
        return(take ||notTake);
    }
}