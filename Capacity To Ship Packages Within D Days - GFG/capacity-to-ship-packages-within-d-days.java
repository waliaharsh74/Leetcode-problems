//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] arr = new int[N];
            
            int D = Integer.parseInt(read.readLine());
            
            for(int i=0; i<N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.leastWeightCapacity(arr,N,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int leastWeightCapacity(int[] arr, int N, int days) {
        // code here
        int ans=0;
        int l=max(arr);
        int r=sum(arr);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(arr,days,mid)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;

    }
    
    static boolean isPossible(int[] arr, int days,int mid){
        int sum=0;
        int cnt=1;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]<=mid){
                sum+=arr[i];
            }
            else{
                sum=0;
                cnt++;
                sum+=arr[i];
            }
        }
        return cnt<=days;

    }

    static int max(int[] arr){
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            ans=Math.max(arr[i],ans);
        }
        return ans;
    }
    static int sum(int[] arr){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans+=arr[i];
        }
        return ans;
    }
};