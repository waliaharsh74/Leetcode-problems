//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    static ArrayList<Integer> max_of_subarrays(int a[], int n, int k) {
        // Your code here
        Deque<Integer>q=new ArrayDeque<>();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=0;i<k;i++){
            if(q.isEmpty()){
                q.add(i);
                
            }
            while(!q.isEmpty() && a[i]>a[q.peekLast()]){
                q.removeLast();
                
            }
            q.offer(i);
        }
        for(int i=k;i<n;i++){
            ans.add(a[q.peek()]);
            
            while(!q.isEmpty() && q.peek()<=i-k){
                q.poll();
            }
            
            while(!q.isEmpty() && a[i]>a[q.peekLast()]){
                q.removeLast();
                
            }
            q.offer(i);
        }
        ans.add(a[q.peek()]);
        return ans;
        
    }
}