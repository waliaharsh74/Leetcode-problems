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

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int threshold) {
        int ans=-1;
        int l=1;
        int r=max(nums);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(nums,threshold,mid)){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    
    static boolean isPossible(int[] nums, int threshold,int mid){
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=Math.ceil((double)nums[i]/(double)mid);

        }
        if(sum<=threshold)return true;
        return false;
    }

    static int max(int[] nums){
        int ans=0;
        for(int i=0;i<nums.length;i++){
            ans=Math.max(ans,nums[i]);
        }
        return ans;
    }
}