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
    public TreeNode searchBST(TreeNode root, int key) {
        TreeNode curr=root;
        if(curr==null) return null;
        
        if(key==curr.val)return curr;
        
        
        if(key>curr.val){
            return searchBST(curr.right,key);
        }
        
       
        return searchBST(curr.left,key);
        
        
    }
}