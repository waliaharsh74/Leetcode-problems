//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,P,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int v,int p, int[][] arr)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<v;i++){
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0;i<arr.length;i++){
            adj.get(arr[i][0]).add(arr[i][1]);
        }

        int indeg[]=new int[v];
        for(int i=0;i<v;i++){
            for(Integer neighbor:adj.get(i)){
                indeg[neighbor]++;
            }
        }

        ArrayDeque<Integer>q=new ArrayDeque<>();

        for(int i=0;i<v;i++){
            if(indeg[i]==0)
                q.add(i);
        }
        int cnt=0;

        while(!q.isEmpty()){
            int cur=q.poll();
            cnt++;
            for(Integer neighbor:adj.get(cur)){
                indeg[neighbor]--;
                if(indeg[neighbor]==0){
                    q.add(neighbor);
                    
                }
            }
        }
        // System.out.println(cnt);
        if(cnt==v)return true;
        return false;
    }
    
}