//{ Driver Code Starts
// driver code

import java.util.*;
import java.io.*;
import java.lang.*;

class Node
{
    int data;
    Node next;
}

class GFG
{
    public static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }
    
    public static void makeLoop(Node head, int x){
        if (x == 0)
            return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x)
        {
            curr = curr.next;
            currentPosition++;
        }
        
        while (last.next != null)
            last = last.next;
        last.next = curr;
    }
    
    public static boolean detectLoop(Node head){
        Node hare = head.next;
        Node tortoise = head;
        while( hare != tortoise )
        {
            if(hare==null || hare.next==null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }
    
    public static int length(Node head){
        int ret=0;
        while(head!=null)
        {
            ret += 1;
            head = head.next;
        }
        return ret;
    }
    
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t--> 0)
        {
            int n = sc.nextInt();
            
            int num = sc.nextInt();
            Node head = newNode(num);
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                num = sc.nextInt();
                tail.next = newNode(num);
                tail = tail.next;
            }
            
            int pos = sc.nextInt();
            makeLoop(head, pos);
            
            Solution x = new Solution();
            x.removeLoop(head);
            
            if( detectLoop(head) || length(head)!=n )
                System.out.println("0");
            else
                System.out.println("1");
        }
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution
{
    //Function to remove a loop in the linked list.
    static Node detectAndRemoveLoop(Node node)
    {
        Node slow = node, fast = node;
        Node prev=null;
        while (slow != null && fast != null
               && fast.next != null) {
            prev=slow;      
            slow = slow.next;
            fast = fast.next.next;
  
            // If slow and fast meet at same point then loop
            // is present
            if (slow == fast) {
                // removeLoops(slow, node);
                return prev; 
            }
        }
        return null;
    }
    
    // static void removeLoops(Node loop, Node head)
    // {
    //     Node meet = detectAndRemoveLoop;
    //     Node start = head;
  
    //     // Count the number of nodes in loop
    //     int k = 1, i;
    //     Node prevNode = ptr1;
    //     while (ptr1.next != ptr2) {
    //         // keeping track beforeing moving next
    //         prevNode = ptr1;
    //         ptr1 = ptr1.next;
    //         k++;
    //     }
    //     prevNode.next = null;
    // }
    
    public static void removeLoop(Node head){
        // code here
        // remove the loop without losing any nodes
        Node meet = detectAndRemoveLoop(head);
        if(meet==null)return;
        Node match=meet.next;
        
        Node start = head;
        while(start!=match){
            start=start.next;
            match=match.next;
            meet=meet.next;
            
        }
        meet.next=null;
    }
}