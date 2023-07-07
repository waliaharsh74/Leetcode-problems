//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int i= sm(arr,n,x);
        int j= lm(arr,n,x);
        return (i!=-1)?(i-j+1):0;
        
    }
    int sm(int[] arr, int n, int x){
        int ans=-1;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==x){
                ans=mid;
                l++;
                continue;
            }
            if(arr[mid]<x){
                l=mid+1;
            }
            
            else{
                r=mid-1;
            }
        }
        return ans;
    }
    int lm(int[] arr, int n, int x){
        int ans=-1;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(arr[mid]==x){
                ans=mid;
                r--;
                continue;
            }
            if(arr[mid]>x){
                r=mid-1;
            }
            
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}