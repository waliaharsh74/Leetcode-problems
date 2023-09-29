//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
     Arrays.sort(arr);
    boolean ans = false;
    
    for (int i = 0; i < n - 2; i++) {
        // Skip duplicates to avoid counting the same triplet multiple times
        if (i == 0 || (i > 0 && arr[i] != arr[i - 1])) {
            int j = i + 1;
            int k = n - 1;
            
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                
                if (sum == 0) {
                    ans = true;
                    return true; // Return true immediately when a triplet is found
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
    }
    
    return ans;
    }
}