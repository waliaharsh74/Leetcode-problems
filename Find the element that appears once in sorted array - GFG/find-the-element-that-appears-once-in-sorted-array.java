//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG 
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0;i < n;i++)
            {
                arr[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findOnce(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    int findOnce(int arr[], int n)
    {
        if(n==1)return arr[0];
        int ans = -1;
        for (int i = 0; i < n-1; i += 2) {
            if (arr[i] != arr[i + 1]) {
                ans = arr[i];
                break;
            }
        }
       
        if (arr[n - 2] != arr[n - 1])
            ans = arr[n-1];
            
        return ans;    
    }
}