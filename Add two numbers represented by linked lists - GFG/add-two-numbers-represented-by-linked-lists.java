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
    static Node addTwoLists(Node l1, Node l2){
        // code here
        // return head of sum lis
        // long ans=0,l1=0,l2=0;
        // Node cur1=first;
        // Node cur2=second;
        // while(cur1!=null){
        //     l1++;
        //     cur1=cur1.next;
        // }
        // // System.out.println(l1);
        
        // l1=l1-1;
        // cur1=first;
        // while(cur1!=null){
        //     ans+=cur1.data*Math.pow(10,l1);
            
        //     cur1=cur1.next;
        //     l1--;
        // }
        // // System.out.println(ans);
        
        
        // while(cur2!=null){
        //     l2++;
        //     cur2=cur2.next;
        // }
        // // System.out.println(l2);
        // l2=l2-1;
        // cur2=second;
        // while(cur2!=null){
        //     ans+=cur2.data*Math.pow(10.0,l2);
        //     cur2=cur2.next;
        //     l2--;
        // }
        // // System.out.println(ans);
        // Node newHead=new Node((int)ans%10);
        // Node cur=newHead;
        // ans/=10;
        // while(ans>0){
        //     long d=ans%10;
        //     cur.next=new Node((int)d);
        //     cur=cur.next;
        //     ans/=10;
        // }
        // // cur.next=null;
        // return reverse(newHead);
        
        
        Node prev = null;
        // Create 3 stacks
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        Stack<Node> s3 = new Stack<Node>();
        // Fill first stack with first List Elements
        while (l1 != null) {
            s1.add(l1);
            l1 = l1.next;
        }
        // Fill second stack with second List Elements
        while (l2 != null) {
            s2.add(l2);
            l2 = l2.next;
        }
        int carry = 0;
        // Fill the third stack with the sum of first and
        // second stack
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum
                = s1.peek().data + s2.peek().data + carry;
            Node temp = new Node(sum % 10);
            s3.add(temp);
            if (sum > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            s1.pop();
            s2.pop();
        }
        while (!s1.isEmpty()) {
            int sum = carry + s1.peek().data;
            Node temp = new Node(sum % 10);
            s3.add(temp);
            if (sum > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            s1.pop();
        }
        while (!s2.isEmpty()) {
            int sum = carry + s2.peek().data;
            Node temp = new Node(sum % 10);
            s3.add(temp);
            if (sum > 9) {
                carry = 1;
            }
            else {
                carry = 0;
            }
            s2.pop();
        }
        // If carry is still present create a new node with
        // value 1 and push it to the third stack
        if (carry == 1) {
            Node temp = new Node(1);
            s3.add(temp);
        }
        // Link all the elements inside third stack with
        // each other
        if (!s3.isEmpty())
            prev = s3.peek();
        while (!s3.isEmpty()) {
            Node temp = s3.peek();
            s3.pop();
            if (s3.size() == 0) {
                temp.next = null;
            }
            else {
                temp.next = s3.peek();
            }
        }
        return (prev);
        
        
        
        
        
        
        
        
    }
}