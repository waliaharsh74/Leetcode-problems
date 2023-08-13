//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countRevPairs(int N, int arr[]) {
        // Code here
        int n=arr.length;
        divide(arr,0,n-1);
        return(int) cnt;
    }
    
    long cnt=0;
     void divide(int arr[],int low,int high){
        if(low>=high)return;
        int mid=low+(high-low)/2;
        divide(arr,low,mid);
        divide(arr,mid+1,high);
        countPairs(arr,low,mid,high);
        conquer(arr,low,mid,high);

    }

     void countPairs(int arr[],int low,int mid,int high){
        int right=mid+1;
        for(int i=low;i<=mid;i++){
            while(right<=high && arr[i]>2L*arr[right]){
                right++;
            }
                cnt+=right-(mid+1);
        }
    }

     void conquer(int arr[],int low,int mid,int high){
        int merged[]=new int[high-low+1];
        int ind1=low;
        int ind2=mid+1;
        int x=0;
        while(ind1<=mid && ind2<=high){
            if(arr[ind1]>=arr[ind2]){
                merged[x++]=arr[ind2++];
            }
            else{
                // cnt+=mid-low+1;
                merged[x++]=arr[ind1++];
            }
        }
        while(ind1<=mid){
            
            merged[x++]=arr[ind1++];
            
        }
        while( ind2<=high){
            
            merged[x++]=arr[ind2++];
            
        }
        for(int k=0,l=low;k<merged.length;k++,l++){
            arr[l]=merged[k];
        }

    }
}