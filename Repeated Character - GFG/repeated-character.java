//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s;
            s = sc.next();
            
            Solution ob = new Solution();
            char res = ob.firstRep(s);
            if (res == '#')
                System.out.println(-1);
            else
                System.out.println(res);
             
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
    char firstRep(String s)
    {
        // your code here
        int[] c =new int[256];
        Arrays.fill(c,0);
        for(int i=0;i<s.length();i++){
            c[s.charAt(i)]++;
            
        }
        for(int i=0;i<s.length();i++){
            if(c[s.charAt(i)]>=2){
                return s.charAt(i);
            }
            
            
        }
        return'#';
    }
}