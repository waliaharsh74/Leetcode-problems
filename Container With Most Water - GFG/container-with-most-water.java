//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
import java.lang.*;


class GFG {
	public static void main (String[] args) throws IOException{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine()); // input size of array
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split("\\s+");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
		    }
		    Solve T = new Solve();
            long ans = T.maxArea(arr,n);
            System.out.println(ans);
		}
	}
}

// } Driver Code Ends


//User function Template for Java


class Solve{
    
    long maxArea(int a[], int n){
        // Code Here
        int s=0;
        int e=n-1;
        int maxArea=0;
        
        while(s<e){
            int height=Math.min(a[s],a[e]);
            int distance=e-s;
            int area=height*distance;
            maxArea=Math.max(area,maxArea);
            if(a[s]<a[e]){
                s++;
            }
            else{
                e--;
            }
        }
        
        return maxArea;
        
    }
    
}