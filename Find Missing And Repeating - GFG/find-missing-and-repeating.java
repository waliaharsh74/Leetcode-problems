//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int a[], int n) {
        // code here
        int[]ans=new int[2];
        int xor=0;
        for(int i=0;i<a.length;i++){
            xor=xor^a[i];
            xor=xor^(i+1);
        }
        int sum=xor&(-xor);
        int sum1=0;
        int sum2=0;

        for(int i=0;i<a.length;i++){
            if((a[i]&sum)>0){
                sum1=sum1^a[i];
            }
            else{
                sum2=sum2^a[i];
            }
        }
        for(int i=0;i<a.length;i++){
            if(((i+1)&sum)>0){
                sum1=sum1^(i+1);
            }
            else{
                sum2=sum2^(i+1);
            }
        }
        int cnt = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == sum1) cnt++;
        }

        if (cnt == 2) return new int[] {sum1, sum2};
        return new int[] {sum2, sum1};
        // return ans;
    }
}