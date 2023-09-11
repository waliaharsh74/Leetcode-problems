//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int n, int arr[], int sum){
        // code here
        boolean dp[][]=new boolean [n][sum+1];
        for(int i=0;i<n;i++){
            
            dp[i][0]=true;
        }
        if(arr[0]<=sum)
            dp[0][arr[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=sum;j++){
                boolean pick=false;
                if(j>=arr[i]){
                    
                pick=dp[i-1][j-arr[i]];
                }
                
                boolean nopick=dp[i-1][j];
                dp[i][j]=pick|nopick;
                
            }
        }
        return dp[n-1][sum];
    }
}