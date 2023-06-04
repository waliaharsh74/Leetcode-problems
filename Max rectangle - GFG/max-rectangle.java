//{ Driver Code Starts
import java.util.*;

class FindMinCost
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0)
		{
			int n = sc.nextInt();
			int m = sc.nextInt();
			int arr[][] = new int[n][m];
			for(int i=0; i<n; i++)
			{
				for(int j=0; j<m; j++ )
				{
					arr[i][j] = sc.nextInt();
				}
			}
			System.out.println(new Solution().maxArea(arr, n, m));
		t--;
		}
	}
}
// } Driver Code Ends


/*Complete the function given below*/
class Solution {
    public int maxArea(int a[][], int n, int m) {
        // add code here.
        int b[] = new int[a[0].length];
		int max = 0;
		
		for(int i = 0; i<a.length; i++) {
			for(int j = 0; j<b.length; j++) {
				if(a[i][j] == 0) {
					b[j] = 0;
				} else {
					b[j]++;
				}
			}
			int cur = maxmaximumAreaInHistogramOptimised(b);
			max = Math.max(max, cur);
		}
		
		return max;
    }
    
     int[] previousSmaller(int a[]) {
		int ans[] = new int[a.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i = 0; i<a.length; i++) {
			int e = a[i];
			while(!stack.isEmpty() && a[stack.peek()] >= e) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				ans[i] = -1;
			} else {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}
		return ans;
	}
	
	 int[] nextSmaller(int a[]) {
		int ans[] = new int[a.length];
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for(int i = a.length-1; i>=0; i--) {
			int e = a[i];
			while(!stack.isEmpty() && a[stack.peek()] >= e) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				ans[i] = a.length;
			} else {
				ans[i] = stack.peek();
			}
			stack.push(i);
		}
		return ans;
	}
	
	int maxmaximumAreaInHistogramOptimised(int a[]) {
		int ps[] = previousSmaller(a);
		int ns[] = nextSmaller(a);
		
		int max = 0;
		for(int i = 0; i<a.length; i++) {
			int width = ns[i]-ps[i]-1;
			int curArea = width * a[i];
			max = Math.max(max, curArea);
		}
		
		return max;
	}
}