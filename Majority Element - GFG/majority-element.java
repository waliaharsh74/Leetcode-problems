//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int n)
    {
        // your code here
        int count =1;
        int index=0;
        if(n==1)return a[0];
        for(int i=1;i<n;i++){
            if(a[i]==a[index]){
                count++;
            }
            else{
                count--;
            }
            if(count==0){
                index=i;
                count=1;
            }
            
            
            
        }
        int ans=a[index];
        count=0;
        for(int i=0;i<n;i++){
            
            if(a[i]==ans){
                count++;
                
            }
        }
        if(count>n/2) return ans;
        return -1;
        
    }
}