//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    
    static Node reverse(Node head){
        Node prev=null;
        Node next=null;
        Node cur=head;
        while(cur!=null){
            next=cur;
            cur=cur.next;
            next.next=prev;
            prev=next;
            
        }
        return prev;
        
    }
    //Function to add two numbers represented by linked list.
    static Node addTwoLists(Node head1, Node head2){
        // code here
       Node r1 = reverse(head1);
		Node r2 = reverse(head2);
		
		Node head = null;
		int carry = 0;
		
		while(r1 != null || r2 != null || carry == 1) {
			int sum = carry;
			if(r1 != null) {
				sum += r1.data;
				r1 = r1.next;
			}
			if(r2 != null) {
				sum += r2.data;
				r2 = r2.next;
			}
			
			int digit = sum % 10;
			carry = sum / 10;
			
			Node newNode = new Node(digit);
			if(head == null) {
				head = newNode;
			} else {
				newNode.next = head;
				head = newNode;
			}
		}
		return head;
   
        
    }
    
    
}