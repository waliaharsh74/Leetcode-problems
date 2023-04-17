//{ Driver Code Starts
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int[] ans = new Solution().kLargest(arr, n, k);
            for (int x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    int[] kLargest(int[] arr, int n, int k) {
        // code here
        ArrayList<Integer> result= new  ArrayList<Integer>();
        
        PriorityQueue<Integer> pq=
        new PriorityQueue<>(Collections.reverseOrder());
        // if(k>n){
            
        //     for(int i=0;i<n;i++){
        //         pq.offer(arr[i]);
        //     }
        //     result.add(pq.poll());
        //     int ans[]=new int[result.size()];
        //     for(int i=0;i<result.size();i++){
        //         ans[i]=result.get(i);
        //     }
        //     return ans;
        // }
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
        }
        while(k>0){
            
            result.add(pq.poll());
            k--;
        }
        // int i=k;
        // int j=0;
        // while(i<n){
        //     pq.remove(arr[j]);
        //     pq.offer(arr[i]);
        //     result.add(pq.peek());
        //     i++;
        //     j++;
            
        // }
        int ans[]=new int[result.size()];
         for(int i=0;i<result.size();i++){
                ans[i]=result.get(i);
            }
            return ans;
        
    }
}