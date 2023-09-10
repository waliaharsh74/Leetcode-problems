//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      int ans = obj.maxCoins(n,a);
      System.out.println(ans);
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
  public static int maxCoins(int N, int[] nums) {
    // code here
       int n=nums.length;
        int[] arr = new int[n + 2];
    arr[0] = 1;
    arr[n + 1] = 1;
    System.arraycopy(nums, 0, arr, 1, n);
        
        int dp[][]=new int [n+2][n+2];
        for(int i=n;i>0;i--){
            for(int j=1;j<=n;j++){
                if(i>j)continue;
                int max=Integer.MIN_VALUE;

                for(int k=i;k<=j;k++){
                    int coin=arr[i-1]*arr[k]*arr[j+1]+dp[i][k-1]+dp[k+1][j];
                    max=Math.max(coin,max);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n];

  }
}
     