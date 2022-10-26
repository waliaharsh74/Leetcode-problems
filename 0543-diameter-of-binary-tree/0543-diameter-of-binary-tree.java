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
    public int diameterOfBinaryTree(TreeNode root) {
        // if(root==null) return 0;
        // int lh= height(root.left);
        // int rh= height(root.right);
        // int ld=diameterOfBinaryTree(root.left);
        // int rd=diameterOfBinaryTree(root.right);
        // int curr=lh+rh;
        height(root);
        // return Math.max(curr,Math.max(ld,rd));
        return ans;
        
    }
    int ans=0;
    int height(TreeNode root){
         if(root == null) return 0;
        
        int lh = height(root.left);
        int rh = height(root.right);
        ans = Math.max(ans, lh+rh);
        
        // obj.a = Math.max(obj.a, lh+rh);
        
        return Math.max(lh, rh) + 1;
        
    }
}