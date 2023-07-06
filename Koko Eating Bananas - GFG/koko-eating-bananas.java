//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int h) {
        // code here
         int l=1;
        // int ans=0;
        int r=max(piles);
        while(l<=r){
            int mid=l+(r-l)/2;
            int val=totalTime(piles,mid);
            if(val<=h){
                
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
    
    static int totalTime(int[] piles,int hourly){
        int th=0;

        for(int i=0;i<piles.length;i++){
            th+=Math.ceil((double)piles[i]/(double)hourly);

        }
        return th;
    }
    static int max(int[] piles){
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            ans=Math.max(ans,piles[i]);
        }
        return ans;
    }
}
        
