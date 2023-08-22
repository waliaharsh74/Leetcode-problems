//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            long ans = ob.nthStair(n);
            System.out.println(ans);            
        }
    }
}

// } Driver Code Ends


class Solution
{
    public long nthStair(int n)
    {
        // Code here
        return 1+(n/2);
    }
    // int cnt(int n){
    //     if(n==0)return 0;
    //     if(n==1)return 1;
    //     int o=cnt(n-1);
    //     int t=0;
    //     if(n>=2){
            
    //         t=cnt(n-2);
    //     }
    //     return o+t;
    // }
}