//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int matrixMultiplication(int n, int arr[])
    {
        // code here
        int dp[][]=new int[n][n];
        for(int len=2;len<n;len++){
            for(int row=0,col=len;row<n-len;row++,col++){
                dp[row][col]=Integer.MAX_VALUE;
                for(int k=row+1;k<col;k++){
                    
                    dp[row][col]=Math.min(dp[row][col],
                    dp[row][k]+dp[k][col]+arr[row]*arr[k]*arr[col]);
                }
            }
        }
        return dp[0][n-1];
    }
}