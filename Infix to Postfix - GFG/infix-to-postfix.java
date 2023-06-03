//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends

// import java.util.ArrayDeque;

class Solution {
    // Function to convert an infix expression to a postfix expression.
    public static String infixToPostfix(String s) {
        StringBuilder help = new StringBuilder();
        ArrayDeque<Character> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                help.append(s.charAt(i));
            } else if (s.charAt(i) == '(') {
                st.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    help.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && precedence(s.charAt(i)) <= precedence(st.peek())) {
                    help.append(st.pop());
                }
                st.push(s.charAt(i));
            }
        }
        while (!st.isEmpty()) {
            help.append(st.pop());
        }
        return help.toString();
    }

    public static int precedence(char c) {
        switch (c) {
            case '^':
                return 3;
            case '*':
            case '/':
                return 2;
            case '+':
            case '-':
                return 1;
            default:
                return 0;
        }
    }
}

