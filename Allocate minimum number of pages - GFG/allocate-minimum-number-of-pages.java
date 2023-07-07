//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int n,int m)
    {
        //Your code here
        if(m>n)return -1;
        int ans=0;
        int l=min(arr);
        int r=sum(arr);
        while(l<=r){
            int mid=l+(r-l)/2;
            if(pages(arr,n,m,mid)>m){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return l;
    }
    static int pages(int[]arr,int n,int m,int mid){
        int pages=0;
        int cnt=1;
        for(int i=0;i<n;i++){
            if(arr[i]+pages<=mid){
                pages+=arr[i];
                
            }
            else{
                cnt++;
                pages=arr[i];
            }
        }
        // if(cnt>=m)return cnt;
        return cnt;
    }
    
    static int min(int[]arr){
        int ans=0;
        for(int i=0;i<arr.length;i++){
            ans=Math.max(arr[i],ans);
        }
        return ans;
    }
    static int sum(int[]arr){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        return sum;
    }
    
};