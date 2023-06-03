//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String s)
    {
        // Your code here
        // Char[]c=S.toCharArray();
        ArrayDeque<Integer>st=new ArrayDeque<>();
        // int ans=0;
        for(int i=0;i<s.length();i++){
            if(!isOperand(s.charAt(i)))
            {
                st.push(s.charAt(i)-'0');
            }
            else{
                int se=st.pop();
                int f=st.pop();
                st.push(calculate(f,se,s.charAt(i)));
            }
            
        }
        return st.pop();
        
    }
    public static boolean isOperand(char c){
        return (c=='*' ||c=='/' ||c=='+' ||c=='-');
    }
    public static int calculate(int a, int b, char c) {
		switch(c) {
		case '+':
			return a+b;
		case '-':
			return a-b;
		case '*':
			return a*b;
		case '/':
			return a/b;
		}
		return 0;
	}
}