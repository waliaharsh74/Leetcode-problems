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
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans=new ArrayList<>();
        int level=0;
        rightSideView(root,level,ans);
        return ans;
        
        
    }
    void rightSideView(TreeNode root,int level,ArrayList<Integer> ans){
        if(root==null) return;
        if(ans.size()==level) ans.add(root.val);
        rightSideView(root.right,level+1,ans);
        rightSideView(root.left,level+1,ans);
    }
}