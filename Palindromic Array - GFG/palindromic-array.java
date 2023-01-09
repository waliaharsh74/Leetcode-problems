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
	public static int palinArray(int[] a, int n)
           {
            //add code here.
            for(int i=0;i<n;i++)
            {
              int num=a[i];
              int m=num;
              int sum=0;
              while(m>0)
              {
                  int rem=m%10;
                  sum=(sum*10)+rem;
                  m=m/10;
              }
              if(sum!=num)
              {
                  return 0;
              }
            }
            return 1;
           }
}