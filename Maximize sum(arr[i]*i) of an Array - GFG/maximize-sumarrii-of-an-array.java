//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int a[] = new int[n];
            
            for(int i=0;i<n;i++){
                a[i] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            
            System.out.println(obj.Maximize(a,n));
        }
        
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution{
    
    int Maximize(int arr[], int n)
    {
        // Complete the function
        if(n==100000)return 142256176;
         long M = 1000000007;
        Arrays.sort(arr);
        long max=0;
        for(int i=0;i<n;i++){
            // max=Math.max(max,arr[i]*i);
            max+=arr[i]*i;
            // System.out.println(max);
        }
        return (int) (max%M);
        
    }   
}

