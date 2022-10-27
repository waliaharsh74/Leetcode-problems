/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
     
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if(right == null) return left;
        if(left == null) return right;
        
        return root;
    }
    
    
    
    
    
    
    
    
    
    
    
//     public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//         // ArrayList<TreeNode> l1 = new ArrayList<>();
//         // ArrayList<TreeNode> l2 = new ArrayList<>();
//         // isPresent(root,p,l1);
//         // isPresent(root,q,l2);
        
        
//     }
    
    // public static boolean isPresent(TreeNode root, TreeNode target, ArrayList<Integer> ans) {
    //     if(root == null) return false;
    //     if(root == target || isPresent(root.left, target, ans) || isPresent(root.right, target, ans)) {
    //         ans.add(root);
    //         return true;
    //     }
    //     return false;
    // }
}