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
            int A[] = new int[n];
            
            for (int i = 0;i < n;i++)
            {
                A[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            System.out.println(sol.findMin(A, n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    int findMin(int arr[], int n)
    {
        //complete the function here
        int ans=Integer.MAX_VALUE;
        // int n=arr.length;
        int l=0;
        int e=n-1;
        while(l<=e){
            int mid=l+(e-l)/2;
            
            if(arr[l]<arr[e]){
                ans=Math.min(arr[l],ans);
            }
            if(arr[mid]>=arr[l]){
                ans=Math.min(arr[l],ans);
                l=mid+1;
                
            }
            else{
                e=mid-1;
                ans=Math.min(arr[mid],ans);
            }
        }
        return ans;
        
    }
}
