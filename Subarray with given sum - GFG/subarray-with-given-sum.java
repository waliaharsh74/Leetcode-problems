//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int sum) 
    {
        // Your code herer()
        ArrayList<Integer>ans=new ArrayList<Integer>();
        int currentSum = arr[0], start = 0, i;
 
        // Pick a starting point
        for (i = 1; i <= n; i++) {
            // If currentSum exceeds the sum,
            // then remove the starting elements
            while (currentSum > sum && start < i - 1) {
                currentSum = currentSum - arr[start];
                start++;
            }
 
            // If currentSum becomes equal to sum,
            // then return true
            if (currentSum == sum) {
                // int p = i - 1;
                ans.add(start+1);
                ans.add(i);
                return ans;
                
                // System.out.println(
                //     "Sum found between indexes " + start
                //     + " and " + p);
                // // return 1;
            }
 
            // Add this element to curr_sum
            if (i < n)
                currentSum = currentSum + arr[i];
        }
        ans.add(-1);
        return ans;
    }
}