//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    static int splitArray(int[] arr , int N, int K) {
        // code here
        return findPages(arr,N,K);
    }
    
    public static int findPages(int[]arr,int n,int m)
    {
        //Your code here
        if(m>n)return -1;
        int ans=0;
        int l=min(arr);
        int r=sum(arr);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(pages(arr,n,m,mid)>m){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
    static int pages(int[]arr,int n,int m,int mid){
        int pages=0;
        int cnt=1;
        for(int i=0;i<n;i++){
            if(arr[i]+pages<=mid){
                pages+=arr[i];
                
            }
            else{
                cnt++;
                pages=arr[i];
            }
        }
        // if(cnt>=m)return cnt;
        return cnt;
    }
    
    static int min(int[]arr){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans=Math.max(arr[i],ans);
        }
        return ans;
    }
    static int sum(int[]arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
};