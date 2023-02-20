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
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String s)
    {
        //code here
        StringBuilder a=new StringBuilder();
        a.append(s);
        StringBuilder b=a.reverse();
        // System.out.println(a);
        // return 0;
        int m=s.length();
        int dp[][]=new int[m+1][m+1];
        return lcs(s,b,m,m,dp);
        
    }
    int lcs(String s,StringBuilder b,int m,int n,int dp[][]){
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    
                }
            }
        }
        return dp[m][m];
    }
}