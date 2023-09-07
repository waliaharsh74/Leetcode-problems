//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    static FastReader sc=new FastReader(System.in);
    public static void main(String args[]) throws IOException{
       
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            String []arr=new String[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.next();
            }
            Solution obj=new Solution();
            int res=obj.longestChain(N, arr);
            System.out.println(res);
        }
    }
   static class FastReader{
 
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;
 
        FastReader(InputStream is) {
            in = is;
        }
 
        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }
 
        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan());
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }
 
        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
 
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan());
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
   
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public int longestChain(int N, String arr[]){
     //code here
    Arrays.sort(arr,(a,b)->{
            return a.length()-b.length();
        });
        // return 0;
        int n=arr.length;
        int dp[]=new int[n];
        int max=1;
        Arrays.fill(dp,1);
        for(int i=0;i<n;i++){
            for(int p=0;p<i;p++){
                if(check(arr[i],arr[p])&& dp[i]<dp[p]+1){
                    dp[i]=dp[p]+1;
                }
            }
            max=Math.max(dp[i],max);
        }
        return max;
    }
    boolean check(String s,String t){
        if(s.length()!=t.length()+1)return false;
        int i=0,j=0;
        while(i<s.length()){
            if(j<t.length() && s.charAt(i)==t.charAt(j) ){
                i++;
                j++;
                
            }else{
                i++;
                // j++;
            }
        }
        return (i==s.length()&& j==t.length());
    }
}