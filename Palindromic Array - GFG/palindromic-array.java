//{ Driver Code Starts
import java.util.*;
class PalindromicArray{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			int[] a = new int[n];
			for(int i = 0 ;i < n; i++)
				a[i]=sc.nextInt();
			GfG g = new GfG();
			System.out.println(g.palinArray(a , n));
		}
	}
}
// } Driver Code Ends


/*Complete the Function below*/


/*Complete the Function below*/
class GfG
{
	public static int palinArray(int[] arr, int n)
    {
     //add code here.
     int ans=1;
        for(int i=0;i<n;i++ ){
            String a=arr[i]+"";
            int l=a.length()-1;
            int j=0;
            while(j<l){
                if(a.charAt(j)==a.charAt(l)){
                    j++;
                    l--;
                }
                else{
                    ans=0;
                    break;
                }
            }
            
        }
        return ans;
    
    }
}