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
    int count;
    int cam = 0;
    int mon = 1;
    int nmon = 2;
    public int minCameraCover(TreeNode root) {
        count = 0;
        int val = helper(root);
        if(val == nmon)
            count++;
        return count;
    }
    public int helper(TreeNode node){
        if(node == null)
            return mon;
        int left = helper(node.left);
        int right = helper(node.right);
        if(left == nmon || right == nmon){
            count++;
            return cam;
        }
        if(left == cam || right == cam){
            return mon;
        }
        return nmon;
    }
}