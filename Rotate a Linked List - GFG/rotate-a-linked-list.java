//{ Driver Code Starts
import java.util.*;
class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
} 

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            
            int a = sc.nextInt();
            Node head = new Node(a);
            Node tail = head;
            
            for (int i=0; i<n-1; i++)
            {
                a = sc.nextInt();
                tail.next = new Node(a);
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution ob = new Solution();
            head = ob.rotate(head,k);
            printList(head);
        }
    }
    
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution{
    //Function to rotate a linked list.
    public Node rotate(Node head, int k) {
        // add code here
        if( head==null || head.next==null) return head;
        int n=0;
        Node cur=head;
        Node last=null;
        while(cur!=null){
            last=cur;
            cur=cur.next;
            n++;
            

        }
        // System.out.println(n);
        cur=head;
        k=n-k;
        if(k==0)return head;
        

        int count=1;
        while(count<n-k){
            cur=cur.next;
            count++;
        }
        // System.out.println(count);
        Node newHead=cur.next;
        cur.next=null;
        last.next=head;
        // cur=newHead;
        // ListNode prev = null;
        // ListNode curr = head;
       return newHead;
    }
}
