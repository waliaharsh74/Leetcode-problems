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
    Integer res = Integer.MAX_VALUE, pre = null;
    public int minDiffInBST(TreeNode root) {
        if (root.left != null) minDiffInBST(root.left);
        if (pre != null) res = Math.min(res, root.val - pre);
        pre = root.val;
        if (root.right != null) minDiffInBST(root.right);
        return res;
    }
}