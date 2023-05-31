//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.util.HashMap;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) 
                a[i] = sc.nextInt();
            Solution g = new Solution();
            
            ArrayList<Integer> ans = g.countDistinct(a, n, k);

            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    public static ArrayList<Integer> countDistinct(int[] arr, int N, int K) {
        ArrayList<Integer> distinctCounts = new ArrayList<>();
        HashMap<Integer, Integer> windowMap = new HashMap<>();

        for (int i = 0; i < K; i++) {
            windowMap.put(arr[i], windowMap.getOrDefault(arr[i], 0) + 1);
        }
        distinctCounts.add(windowMap.size());

        for (int i = K; i < N; i++) {
            windowMap.put(arr[i], windowMap.getOrDefault(arr[i], 0) + 1);

            int prevElement = arr[i - K];
            if (windowMap.get(prevElement) == 1) {
                windowMap.remove(prevElement);
            } else {
                windowMap.put(prevElement, windowMap.get(prevElement) - 1);
            }

            distinctCounts.add(windowMap.size());
        }

        return distinctCounts;
    }
}

