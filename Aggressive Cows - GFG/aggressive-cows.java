//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int solve(int n, int k, int[] arr) {
         Arrays.sort(arr);
        int l=1;
        int ans=0;
        int r=max(arr);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(distance(n,k,arr,mid)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    static boolean distance(int n, int k, int[] arr,int mid){
        int last=arr[0];
        int cnt=1;
        for(int i=1;i<n;i++){
            if(arr[i]-last>=mid){
                last=arr[i];
                cnt++;
            }
        }
        if(cnt>=k)return true;
        return false;
    }
    
    static int max(int []arr){
        int ans= 0;
        for(int i:arr){
            ans=Math.max(i,ans);
        }
        return ans;
    }
}