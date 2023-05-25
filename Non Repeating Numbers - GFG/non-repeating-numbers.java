//{ Driver Code Starts
//Initial Template for Java

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
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] v = new int[2 * n + 2];
            for(int i = 0; i < 2 * n + 2; i++)
            {
                v[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            int[] ans = ob.singleNumber(v);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int[] singleNumber(int[] a)
    {
        // Code here
        int sum=0;
        for(int i=0;i<a.length;i++){
            sum^=a[i];
            
        }
        int x=0,y=0;
        int rightbit=sum&~(sum-1);
        for(int i=0;i<a.length;i++){
            if((rightbit & a[i])>0){
                x=x^a[i];
            }
            else{
                y=y^a[i];
            }
        }
        int[]ans=new int[2];
        if(x>y){
            ans[0]=y;
            ans[1]=x;
        }
        else{
            
            ans[0]=x;
            ans[1]=y;
        }
        return ans;
        
    }
}