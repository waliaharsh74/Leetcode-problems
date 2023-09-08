//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
            }
            Solution obj=new Solution();
            int res=obj.NumberofLIS(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int NumberofLIS(int N, int nums[]){
        // Code here
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n];
        
        Arrays.fill(length, 1);
        Arrays.fill(count, 1);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = 0;
                    }
                    if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int maxLength = 0;
        int result = 0;

        for (int len : length) {
            maxLength = Math.max(maxLength, len);
        }

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLength) {
                result += count[i];
            }
        }
        
        return result;
    }
}