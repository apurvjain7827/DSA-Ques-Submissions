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
    public boolean ans;
    public boolean isValidBST(TreeNode root) {
        ans = true;
        if(root.left == null && root.right == null)
            return true;
        helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }
    public void helper(TreeNode node, long min, long max){
        if(node == null)
            return;
        if(node.val > min && node.val < max){
            helper(node.left, min, node.val);
            helper(node.right, node.val, max);
            return;
        }
        ans = false;
    }
}