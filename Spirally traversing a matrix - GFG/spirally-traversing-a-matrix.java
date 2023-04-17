//{ Driver Code Starts
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
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int mat[][], int r, int c)
    {
        // code here 
          int R=mat.length;
        int C=mat[0].length;
        ArrayList<Integer> ans= new ArrayList<Integer>();
    int top = 0, left = 0, bottom = R - 1, right = C - 1;

    while (top <= bottom && left <= right) {
      for (int i = left; i <= right; i++)
        ans.add(mat[top][i]);

      top++;

      for (int i = top; i <= bottom; i++)
        ans.add(mat[i][right]);
        // System.out.print(mat[i][right] + " ");

      right--;

      if (top <= bottom) {
        for (int i = right; i >= left; i--)
            ans.add(mat[bottom][i]);
          // System.out.print(mat[bottom][i] + " ");

        bottom--;
      }

      if (left <= right) {
        for (int i = bottom; i >= top; i--)
        ans.add(mat[i][left]);
          // System.out.print(mat[i][left] + " ");

        left++;
      }
    }
    return ans;
    }
}
