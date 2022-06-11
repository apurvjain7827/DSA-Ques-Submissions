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
    public int size(TreeNode node){
        if(node == null){
            return 0;
        }
        int ls = size(node.left);
        int rs = size(node.right);
        return Math.max(ls, rs) +1;
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int ls = size(root.left);
        int rs = size(root.right);
        boolean leftAns = isBalanced(root.left);
        boolean rightAns = isBalanced(root.right);
        if(leftAns == false || rightAns == false){
            return false;
        }
        if(ls-rs <= 1 && ls-rs >= -1){
            return true;
        }
        return false;
    }
}