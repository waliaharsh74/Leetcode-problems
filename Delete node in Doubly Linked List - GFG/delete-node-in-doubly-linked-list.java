//{ Driver Code Starts
//Initial Template for Java
import java.util.*;

class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
class Delete_Node_From_DLL
{
	Node head;
	Node tail;
	
	void addToTheLast(Node node)
	{
		if(head ==  null)
		{
			head = node;
			tail = node;
		}
		else
		{
			tail.next = node;
			tail.next.prev = tail;
			tail = tail.next;
		}
	}
	
	void printList(Node head)
	{	Node temp = head;
		while(temp != null)
		{
			System.out.print(temp.data+" ");
			temp =  temp.next;
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			Delete_Node_From_DLL list = new Delete_Node_From_DLL();
			
			int a1 = sc.nextInt();
			Node head = new Node(a1);
			list.addToTheLast(head);
			
			for(int i=1;i<n;i++)
			{
				int a = sc.nextInt();
				list.addToTheLast(new Node(a));
			}
			a1 = sc.nextInt();
			Solution g = new Solution();
			//System.out.println(list.temp.data);
			Node ptr = g.deleteNode(list.head, a1);
			list.printList(ptr);
			t--;
		}
	}
}


                               
// } Driver Code Ends


//User function Template for Java

/* Structure of linkedlist node
class Node
{
	int data;
	Node next;
	Node prev;
	Node(int d)
	{
		data = d;
		next = prev = null;
	}
}
*/
class Solution
{
    // function returns the head of the linkedlist
    Node deleteNode(Node head,int x)
    {
	// Your code here
	
	    int a=1;
	    Node prev=null;
	    Node temp=head;
	    if(x==1){
	        head=head.next;
	        head.prev=null;
	        return head;
	        
	       // temp=head;
	    }
	    while(a!=x){
	        prev=temp;
	        temp=temp.next;
	        a++;
	        
	    }
	    prev.next=temp.next;
	    if(temp.next!=null){
	        
	        temp.next.prev=prev;
	    }
	    return head;
	    
	   
    }
}
