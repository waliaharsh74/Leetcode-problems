//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends


class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    
    public static class Pair implements Comparable<Pair>{
        int e, s;
        public Pair(int s,int e){
            this.s=s;
            this.e=e;
        }
        
        public int compareTo(Pair that){
           return  this.e-that.e;
        }
    }
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        if(n==0) return 0;
        Pair a[]=new Pair[n];
        for(int i=0;i<n;i++){
            a[i]=new Pair(start[i],end[i]);
        }
        Arrays.sort(a);
        int currEnd=a[0].e;
        int ans=1;
        for(int i=1;i<n;i++){
            if(a[i].s>currEnd){
                ans++;
                currEnd=a[i].e;
                
            }
        }
        return ans;
        
    }
}