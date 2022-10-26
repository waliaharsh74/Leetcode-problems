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
 public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        ArrayDeque<TreeNode> s1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> s2 = new ArrayDeque<>();
        
        s1.push(root);
        while(!s1.isEmpty()) {
            TreeNode pop = s1.pop();
            
            s2.push(pop);
            if(pop.left != null) {
                s1.push(pop.left);
            }
            if(pop.right != null) {
                s1.push(pop.right);
            }
        }
        
        while(!s2.isEmpty()) {
            ans.add(s2.pop().val);
        }
        return ans;
    }
//     void helper(TreeNode root,List<Integer> res){
//         if(root==null) return;
//         helper(root.left,res);
//         helper(root.right,res);
//         res.add(root.val);
        
            
//     }
}