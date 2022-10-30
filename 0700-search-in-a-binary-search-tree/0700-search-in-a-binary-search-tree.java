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
        if(root==null) return null;
        
        TreeNode cur=root;
        while(cur!=null){
            if(cur.val == key) return cur;
		    if(key > cur.val) cur = cur.right;
			else cur = cur.left;
      }
        return null;
        
        
    }
}