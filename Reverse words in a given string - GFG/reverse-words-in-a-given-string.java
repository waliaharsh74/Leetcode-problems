//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String s)
    {
        // code here 
        char[] c=s.toCharArray();
        int start=0;
        int end=0;
        for(;end<s.length();end++){
            if(c[end]=='.'){
                reverseCharacters(c,start,end-1);
                start=end+1;
            }
        }
        reverseCharacters(c,start,end-1);
        reverseCharacters(c,0,s.length()-1);
        return new String(c).trim().replaceAll("( )+", " ");
    }
     void reverseCharacters(char[] c,int i,int j){
        while(i<j){
            char temp=c[i];
            c[i]=c[j];
            c[j]=temp;
            i++;
            j--;
        }
    }
}