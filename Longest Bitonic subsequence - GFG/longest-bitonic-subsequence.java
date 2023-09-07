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
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim();
            String[] s1 = s.split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < s1.length; i++)
                nums[i] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int ans = ob.LongestBitonicSequence(nums);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestBitonicSequence(int[] arr)
    {
        // Code here
        int n=arr.length;
        int dp[]=new int[n];
        int dp2[]=new int[n];
        int max=1;
        int max2=1;
        Arrays.fill(dp,1);
        Arrays.fill(dp2,1);
        for(int i=0;i<n;i++){
            for(int p=0;p<i;p++){
                if(arr[i]>arr[p] && dp[i]<dp[p]+1){
                    dp[i]=dp[p]+1;
                }
            }
            max=Math.max(dp[i],max);
        }
        for(int i=n-1;i>=0;i--){
            for(int p=n-1;p>i;p--){
                if(arr[i]>arr[p]&& dp2[i]<dp2[p]+1){
                    dp2[i]=dp2[p]+1;
                }
            }
            max2=Math.max(dp2[i],max2);
        }
        for(int i=0;i<n;i++){
            max=Math.max(dp[i]+dp2[i]-1,max);
        }
        
        return max;
    }
}