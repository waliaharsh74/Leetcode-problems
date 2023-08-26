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
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int nums[], int l) 
	{ 
	    // Your code goes here
	     int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        boolean[][] dp = new boolean[n][sum + 1];

        dp[0][0] = true;
        dp[0][nums[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 0; target <= sum; target++) {
                dp[i][target] = dp[i - 1][target] || (target >= nums[i] ? dp[i - 1][target - nums[i]] : false);
            }
        }

        int mini = Integer.MAX_VALUE;
        for (int i = 0; i <= sum / 2; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(sum - 2 * i);
                mini = Math.min(mini, diff);
            }
        }

        return mini;
	} 
}
