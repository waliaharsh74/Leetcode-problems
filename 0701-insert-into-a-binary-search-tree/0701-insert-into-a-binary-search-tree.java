/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int key) {
        TreeNode parent=null;
        TreeNode curr=root;
        if(root==null) return new TreeNode(key);
       
        while(curr!=null){
            if(curr.val>key){
                parent=curr;
                curr=curr.left;
            }
            else{
                parent=curr;
                curr=curr.right;
            }
        }
        TreeNode newNode=new TreeNode(key);
        if(key>parent.val){
            parent.right=newNode;
        }
        else if(key<parent.val){
            parent.left=newNode;
        }
        return root;

    }
}