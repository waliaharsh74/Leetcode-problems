//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    
		    Node head1 = null, head2 = null, tail1 = null, tail2 = null;
		    
		    //Input first LL
		    int n1 = sc.nextInt();
            int d1 = sc.nextInt();		    
		    head1 = new Node(d1);
		    tail1 = head1;
		    
		    while(n1-- > 1){
		        Node n = new Node(sc.nextInt());
		        n.next = head1;
		        head1 = n;
		    }
		    
		    //Input second LL
		    int n2 = sc.nextInt();
            int d2 = sc.nextInt();		    
		    head2 = new Node(d2);
		    tail2 = head2;
		    
		    while(n2-- > 1){
		        Node n = new Node(sc.nextInt());
		        n.next = head2;
		        head2 = n;
		    }
		    
		    Solution obj = new Solution();
		    obj.mergeAlt(head1, head2);
		    System.out.println();
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
The structure of node class is : 
class Node {
    int data;
    Node next;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution {
    
    public void mergeAlt(Node head1, Node head2){
        //write your code here, and print the result
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null && temp2!=null){
            System.out.print(temp1.data+" "+temp2.data+" ");
            temp1=temp1.next;
            temp2=temp2.next;
        }
        while(temp1!=null){
            System.out.print(temp1.data+" ");
            temp1=temp1.next;
        }
        System.out.println();
        while(temp2!=null){
            System.out.print(temp2.data+" ");
            temp2=temp2.next;
        }
        
    }
}