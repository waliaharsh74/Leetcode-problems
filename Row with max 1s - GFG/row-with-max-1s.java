//{ Driver Code Starts
//Initial Template for Java

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
            int m = Integer.parseInt(inputLine[1]);
            int[][] arr = new int[n][m];
            inputLine = br.readLine().trim().split(" ");
        
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = Integer.parseInt(inputLine[i * m + j]);
                }
            }
            int ans = new Solution().rowWithMax1s(arr, n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int rowWithMax1s(int mat[][], int R, int C) {
        // code here
        int j,max_row_index = 0;
            j = C - 1;
 
        for (int i = 0; i < R; i++) {
            // Move left until a 0 is found
            while (j >= 0 && mat[i][j] == 1) {
                j = j - 1; // Update the index of leftmost 1
                       // seen so far
                max_row_index = i; // Update max_row_index
            }
        }
          if(max_row_index==0&&mat[0][C-1]==0)
              return -1;
        return max_row_index;
    }
}