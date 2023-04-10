//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String a[], int n){
        int mi=0;
        for(int i=0;i<n;i++){
            if(a[i].length()<a[mi].length()){
                mi=i;
            }
        }
        int ansi=-1;
        int mini=0;
        StringBuilder compare=new StringBuilder();
        StringBuilder min=new StringBuilder();
        compare.append(a[mi]);
        for(int i=0;i<n;i++){
            for(int j=0;j<compare.length();j++){
                if(compare.charAt(j)==a[i].charAt(j)){
                    min.append(compare.charAt(j));
                    
                    
                    
                    // System.out.println(compare);
                    // System.out.println(min);
                }
                
                else{
                    compare.delete(0, compare.length());
                    compare.append(min);
                    min=new StringBuilder();
                    break;
                }
            }
            min=new StringBuilder();
        }
        // System.out.println(min);
        if(compare.length()==0) return"-1";
        return compare.toString();
        
        
        
    }
}