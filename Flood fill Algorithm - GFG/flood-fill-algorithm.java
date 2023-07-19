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
            String[] S1 = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            int[][] image =  new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S2 = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    image[i][j] = Integer.parseInt(S2[j]);
            }
            String[] S3 = br.readLine().trim().split(" ");
            int sr = Integer.parseInt(S3[0]);
            int sc = Integer.parseInt(S3[1]);
            int newColor = Integer.parseInt(S3[2]);
            Solution obj = new Solution();
            int[][] ans = obj.floodFill(image, sr, sc, newColor);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++)
                    System.out.print(ans[i][j] + " ");
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int n=image.length;
        int m=image[0].length;
        int color=image[sr][sc];
        image[sr][sc]=newColor;
        boolean[][]vis=new boolean[n][m];
        vis[sr][sc]=true;
        ArrayDeque<Pair>q=new ArrayDeque<>();
        q.add(new Pair(sr,sc));
        
        while(!q.isEmpty()){
            Pair cur=q.poll();
            int r=cur.r;
            int c=cur.c;
            int delr[]={-1,0,1,0};
            int delc[]={0,1,0,-1};
            for(int i=0;i<4;i++){
                int nrow=r+delr[i];
                int ncol=c+delc[i];
                
                if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && image[nrow][ncol]==color && !vis[nrow][ncol]){
                    image[nrow][ncol]=newColor;
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        return image;
        
    }
    
   
}

class Pair{
    int r;
    int c;
    Pair(int r,int c){
        this.r=r;
        this.c=c;
    }
}