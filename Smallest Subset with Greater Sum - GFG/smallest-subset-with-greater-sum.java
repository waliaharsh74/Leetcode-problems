//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.Collections;


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int N = sc.nextInt();
            int[] Arr = new int[N];
            for (int i = 0; i < N; ++i){
                Arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.minSubset(Arr,N);
            System.out.println(ans);
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution { 
    int minSubset(int[] arr,int n) { 
        long sum=0;
        int ans=0;
        long counterSum=0;
        Arrays.sort(arr);
        int lastElement=arr[n-1];
        for(int i=0;i<n;i++){
            
            sum+=arr[i];
            // ans++;
            
        }
        // sum=sum/2;
        for(int i=n-1;i>=0;i--){
            if(counterSum>sum){
                break;
            }
            counterSum+=arr[i];
            sum-=arr[i];
            ans++;
            
        }
        return ans;
        
     
    }
}