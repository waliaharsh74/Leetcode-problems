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
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int minOperations(String str1, String str2) 
	{ 
	    // Your code goes here
	    int m=str1.length();
	    int n=str2.length();
	    int dp[][]=new int[m+1][n+1];
	    for(int i=0;i<=m;i++){
	        Arrays.fill(dp[i],-1);
	        
	    }
	    int l=lcs(m, n, str1, str2,dp);
	   // int l= dp[m][n];
	   // System.out.println(l);
	    return m+n-(2*l);
	    
	}
	
	 int lcs(int x, int y, String s1, String s2,int dp[][]){
        if(x==0 || y==0)return 0;
        if(dp[x][y]!=-1)return dp[x][y];
        // for(int i=1;i<=x;i++)
        {
            // for(int j=1;j<=y;j++)
            {
                if(s1.charAt(x-1)==s2.charAt(y-1)){
                    // dp[i][j]=dp[i-1][j-1]+1;
                    dp[x][y]=lcs(x-1,y-1,s1,s2,dp)+1;
                }
                else{
                    dp[x][y]=Math.max(lcs(x-1,y,s1,s2,dp),lcs(x,y-1,s1,s2,dp));
                    
                }
            }
        }
        return dp[x][y];
    }
}