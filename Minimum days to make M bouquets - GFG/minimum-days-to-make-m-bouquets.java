//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        while(t-- > 0){
            
            
           int M = sc.nextInt();
           int K = sc.nextInt();
            
            
            //int n = sc.nextInt();
            sc.nextLine();
            String s[]=sc.nextLine().split(" ");
            int n=s.length;
            int[] bloomDay = new int[n];
            for(int i=0;i<n;i++) bloomDay[i]=Integer.parseInt(s[i]);
            
            Solution obj = new Solution();
            int res = obj.solve(M, K, bloomDay);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static int solve(int m, int k, int[] arr) {
       int ans=-1;
        int l=1;
        int r=max(arr);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(arr,m,k,mid)){
                ans=mid;
                r=mid-1;

            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    
    static boolean isPossible(int[] arr, int m, int k,int mid){
        int ans=0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(mid>=arr[i]){
                count++;
                // ans=Math.max(ans,count);?

                
            }else{
                ans+=count/k;
                count=0;
            }
            
        }
        ans+=count/k;
        return ans>=m;
    }
    static int max(int[] arr){
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            ans=Math.max(arr[i],ans);
        }
        return ans;
    }
}