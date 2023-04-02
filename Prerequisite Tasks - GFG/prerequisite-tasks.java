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
			if(ob.isPossible(N,prerequisites))
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
    public boolean isPossible(int V, int[][] prerequisites)
    {
        // Your Code goes here
        ArrayList<ArrayList<Integer>>adj=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        int m=prerequisites.length;
        for(int i=0;i<m;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        int InDeg[]=new int[V];
        
        for(int i=0;i<V;i++){
            for(Integer neighbor:adj.get(i)){
                InDeg[neighbor]++;
            }
        }
        
        List<Integer>list =new ArrayList<>();
        Queue<Integer> q =new ArrayDeque<>();
        for(int i=0;i<V;i++){
            if(InDeg[i]==0){
                q.add(i);
                // list.add()
            }
        }
        while(!q.isEmpty()){
            int cur=q.poll();
            list.add(cur);
            for(Integer neighbor:adj.get(cur)){
                InDeg[neighbor]--;
                if(InDeg[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        // System.out.println(list.size());
        if(list.size()==V)return true;
        return false;
        
    }
    
}