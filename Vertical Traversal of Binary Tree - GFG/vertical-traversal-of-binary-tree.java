//{ Driver Code Starts
//Initial Template for Java

//Contributed by Sudarshan Sharma
import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
                Solution obj = new Solution();
                ArrayList <Integer> res = obj.verticalOrder(root);
                for (Integer num : res) System.out.print(num + " "); 
                System.out.println();
    	        
	        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static class Pair {
        int hd;
        Node node;
        
        public Pair(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
    //Function to find the vertical order traversal of Binary Tree.
    static ArrayList <Integer> verticalOrder(Node root)
    {
                Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        if(root == null) return null;
        Queue<Pair> q = new LinkedList<>();
        
        q.add(new Pair(0, root));
        while(!q.isEmpty()) {
            Pair cur = q.poll();
            int key = cur.hd;
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<Integer>());
            }
            map.get(key).add(cur.node.data);
            
            if(cur.node.left != null) {
                q.add(new Pair(key-1, cur.node.left));
            }
            if(cur.node.right != null) {
                q.add(new Pair(key+1, cur.node.right));
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(ArrayList<Integer> e: map.values()) {
            ans.addAll(e);
        }
        return ans;
        
        
        
        
        
        
        
        
        
        // add your code here
        
        
        // ArrayList <Integer> ans=new ArrayList <Integer>();
        // TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
        // int hd =0;
        // getVerticalOrder(root,hd,m);
          
        // // Traverse the map and print nodes at every horizontal
        // // distance (hd)
        // for (Entry<Integer, Vector<Integer>> entry : m.entrySet())
        // {
        //     System.out.println(entry.getValue());
        //     ans.add(entry.getValue());
            
        // }
        // return ans;
        
    }
    // void getVerticalOrder(Node root, int hd,
    //                             TreeMap<Integer,Vector<Integer>> m)
    // {
    //     // Base case
    //     if(root == null)
    //         return;
          
    //     //get the vector list at 'hd'
    //     Vector<Integer> get =  m.get(hd);
          
    //     // Store current node in map 'm'
    //     if(get == null)
    //     {
    //         get = new Vector<>();
    //         get.add(root.key);
    //     }
    //     else
    //         get.add(root.key);
          
    //     m.put(hd, get);
          
    //     // Store nodes in left subtree
    //     getVerticalOrder(root.left, hd-1, m);
          
    //     // Store nodes in right subtree
    //     getVerticalOrder(root.right, hd+1, m);
    // }
}