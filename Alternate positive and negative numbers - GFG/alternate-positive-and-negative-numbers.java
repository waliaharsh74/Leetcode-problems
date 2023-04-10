//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        Queue<Integer>pos=new ArrayDeque<Integer>();
        Queue<Integer>neg=new ArrayDeque<Integer>();
        
        for(int i=0;i<n;i++){
            if(arr[i]>=0){
                pos.add(arr[i]);
            }
            else{
                neg.add(arr[i]);
                
            }
        }
        
        int i=0;
        while(!pos.isEmpty() && !neg.isEmpty()){
            if(!pos.isEmpty() && i%2==0 ){
                
                arr[i]=pos.poll();
                i++;
            }
            
            if(!neg.isEmpty( ) && i%2!=0){
                
                arr[i]=neg.poll();
                i++;
            }
        }
        while(!pos.isEmpty()){
            arr[i]=pos.poll();
                i++;
        }
        while(!neg.isEmpty()){
            arr[i]=neg.poll();
                i++;
        }
        
        
        
        
        
    }
}