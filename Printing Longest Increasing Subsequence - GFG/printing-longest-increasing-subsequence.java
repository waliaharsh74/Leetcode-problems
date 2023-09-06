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
            ArrayList<Integer>ans=obj.longestIncreasingSubsequence(N, arr);
            for(int i=0;i<ans.size();i++){
                System.out.print(ans.get(i)+" ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public ArrayList<Integer> longestIncreasingSubsequence(int n, int arr[]){
        // Code here
        int dp[]=new int [n+1];
        int hash[]=new int [n+1];
        Arrays.fill(dp,1);
        int li=0;
        int maxi=0;
        for(int i=0;i<n;i++){
            hash[i]=i;
            for(int prev=0;prev<i;prev++){
                if(arr[i]>arr[prev] && 1+dp[prev]>dp[i]){
                    dp[i]=1+dp[prev];
                     hash[i]=prev;
                   
                }
            }
             if(maxi<dp[i]){
                maxi=dp[i];
                li=i;
                        
                       
            }
        }
        ArrayList<Integer>ans=new ArrayList<>();
        ans.add(arr[li]);
        while(hash[li]!=li){
            li=hash[li];
            ans.add(arr[li]);
        }
        Collections.reverse(ans);
        return ans;
    }
    
}
