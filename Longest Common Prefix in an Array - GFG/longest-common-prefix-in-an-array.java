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
        
        // code here
        // int sl=Integer.MAX_VALUE;
        // for(int i=0;i<arr.length;i++){
        //     sl=Math.min(arr[i].length(),sl);
        // }
        // int pt=0;
        // String ref=arr[0];
        // for(int i=0;i<sl;i++){
        //     // sl=Math.min(arr[i].length(),sl);
        //     for(int j=1;j<arr.length;j++){
        //         if(ref.charAt(i)!=arr[j].charAt(i)){
        //             pt=i-1;
        //         }
                
        //     }
        // }
        
        // if(pt==-1) return"-1";
        
        // return ref.substring(0,pt+1);
        
         int size = a.length;
  
        /* if size is 0, return empty string */
        if (size == 0)
            return "-1";
  
        if (size == 1)
            return a[0];
  
        /* sort the array of strings */
        Arrays.sort(a);
  
        /* find the minimum length from first and last string */
        int end = Math.min(a[0].length(), a[size-1].length());
  
        /* find the common prefix between the first and
           last string */
        int i = 0;
        while (i < end && a[0].charAt(i) == a[size-1].charAt(i) )
            i++;
  
        String pre = a[0].substring(0, i);
        if(i==0)return"-1";
        return pre;
    }
}