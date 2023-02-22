//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int arr[], int n)
    
    {
        // Your code here
        int dp[][]=new int[n][n];
        for(int x[]: dp) {
			Arrays.fill(x, -1);
		}
        countMaximum(arr,0,n-1,dp);
        long l=dp[0][n-1];
        return l;
        
    }
    static int countMaximum(int arr[], int i,int j,int dp[][]){
        if(j-i==1){
            
            int l=Math.max(arr[i],arr[j]);
            return l;
            
        } 
        
		if(dp[i][j] != -1) return dp[i][j];
        int l=arr[i]+Math.min(countMaximum(arr,i+2,j,dp),countMaximum(arr,i+1,j-1,dp));
        int r=arr[j]+Math.min(countMaximum(arr,i,j-2,dp),countMaximum(arr,i+1,j-1,dp));
    
          return dp[i][j] = Math.max(l, r);  
    }
}
