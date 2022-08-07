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
    int len;
    public int longestUnivaluePath(TreeNode root) {
        len = 1;
        helper(root, 10000);
        return len-1;
    }
    
    public int helper(TreeNode node, int call){
        if(node == null){
            return 0;
        }
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        
        len = Math.max(len, left + right + 1);
        
        if(call != node.val)
            return 0;
        return Math.max(left, right) + 1;
    }
}