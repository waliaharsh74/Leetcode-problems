//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            ob.MakeZeros(matrix);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public void  MakeZeros(int[][] matrix)
    {
        // code here
        
        int n=matrix.length;
        int m=matrix[0].length;
        int copy[][]=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                copy[i][j]=matrix[i][j];
            
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(copy[i][j]==0){
                    
                    mark(i,j,n,m,matrix,copy);
                }
            }
        }
        
    }
    void mark(int k,int j,int n,int m,int[][] matrix,int[][] copy){
        int row[]={1,0,-1,0};
        int col[]={0,1,0,-1};
        int sum=0;
        for(int i=0;i<4;i++){
            int nrow=k+row[i];
            int ncol=j+col[i];
            if(nrow>=0 && ncol>=0 && nrow<n && ncol<m){
                sum+=copy[nrow][ncol];
                matrix[nrow][ncol]=0;
                
            }
            matrix[k][j]=sum;
        }
    }
}