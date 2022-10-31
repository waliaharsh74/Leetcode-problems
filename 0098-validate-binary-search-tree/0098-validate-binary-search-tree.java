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
    public boolean isValidBST(TreeNode root) {
        List <TreeNode> l1=new ArrayList<>();
        // List <TreeNode> l2=new Arraylist<>();
        InOrder(root,l1);
        return arraySortedOrNot(l1,l1.size());
        
        
        
    }
    void InOrder(TreeNode root,List <TreeNode> l1){
        if(root==null) return ;
        InOrder(root.left,l1);
        l1.add(root);
        InOrder(root.right,l1);
        
    }
    boolean arraySortedOrNot(List <TreeNode> l1, int n)
    {
        // Array has one or no element or the
        // rest are already checked and approved.
        if (n == 1 || n == 0)
            return true;
 
        // Unsorted pair found (Equal values allowed)
        if (l1.get(n - 1).val <= l1.get(n - 2).val)
            return false;
 
        // Last pair was sorted
        // Keep on checking
        return arraySortedOrNot(l1, n - 1);
    }
}