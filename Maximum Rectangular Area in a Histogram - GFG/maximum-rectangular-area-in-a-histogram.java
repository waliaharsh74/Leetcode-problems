//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long arr[], long n) 
    {
        // your code here
        long ps[]=new long[arr.length];
        long ns[]=new long[arr.length];
        ps=previousGreaterElement(arr);
        ns=nextGreaterElement(arr);
        long max = 0;
		for(int i = 0; i<arr.length; i++) {
// 			long width = ns[i]-ps[i]-1;
// 			long curArea = width * arr[i];
			max = Math.max(max, arr[i]*(ns[i]-ps[i]-1));
		}
		
		return max;
    }
    
    static long [] previousGreaterElement(long []arr){
        ArrayDeque<Integer> st=new ArrayDeque<>();
        long []ns=new long[arr.length];
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ns[i]=-1;
                // st.push(arr[i]);
            }
            else{
                ns[i]=st.peek();
                
            }
            st.push(i);
        }
        return ns;

    } 
    static long [] nextGreaterElement(long []arr){
        ArrayDeque<Integer> st=new ArrayDeque<>();
        long []ns=new long[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ns[i]=arr.length;
                // st.push(arr[i]);
            }
            else{
                ns[i]=st.peek();
                // st.push(arr[i]);
            }
            st.push(i);
        }
        return ns;

    } 
        
}



