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
    public void flatten(TreeNode root) {
        helper(root);
    }
    public TreeNode helper(TreeNode node){
        if(node == null){
            return null;
        }
        TreeNode right = node.right;
        TreeNode la = helper(node.left);
        TreeNode ra = helper(node.right);
        node.left = null;
        node.right = la;
        TreeNode curr = node;
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = ra;
        return node;
    }
}