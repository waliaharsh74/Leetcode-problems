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
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[][] Intervals = new int[n][2];
            int j = 0;
            for(int i = 0; i < n; i++){
                Intervals[i][0] = Integer.parseInt(s[j]);
                j++;
                Intervals[i][1] = Integer.parseInt(s[j]);
                j++;
            }
            Solution obj = new Solution();
            int[][] ans = obj.overlappedInterval(Intervals);
            for(int i = 0; i < ans.length; i++){
                for(j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int[][] overlappedInterval(int[][] arr)
    {
        // Code here // Code here
        Arrays.sort(arr,new Comparator<int[]>(){
            public int compare(int a[],int b[]){
                if(a[0]!=b[0]){
                    return a[0]-b[0];
                }
                else{
                    return a[1]-b[1];
                }
            }
        });
        LinkedList<int[]> mer=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(mer.isEmpty() || mer.getLast()[1]<arr[i][0]){
                mer.add(arr[i]);
            }
            else{
                mer.getLast()[1]=Math.max(mer.getLast()[1],arr[i][1]);
                
            }
            
        }
        return mer.toArray(new int[mer.size()][]);
    }
}