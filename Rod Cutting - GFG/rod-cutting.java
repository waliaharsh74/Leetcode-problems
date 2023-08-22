//{ Driver Code Starts
import java.io.*;
import java.util.*;

class RodCutting {

    public static void main(String args[])throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        
        int t = Integer.parseInt(in.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

            Solution ob = new Solution();
            out.println(ob.cutRod(arr, n));
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution{
    public int cutRod(int price[], int n) {
        //code here
        int dp[] = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j <= i; j++) {
                max = Math.max(max, price[j - 1] + dp[i - j]);
            }
            dp[i] = max;
        }

        return dp[n];
    }
    int mem(int price[], int n,int dp[]){
        if(n<0)return Integer.MIN_VALUE;
        if(dp[n] != -1) return dp[n];
		if(n == 0) return 0;
        
        
        int max=-1;
        for(int i=0;i<price.length;i++){
            max=Math.max(max, price[i]+mem(price,n-i-1,dp));
        }
        return dp[n]=max;
    }
}