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
    public int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root, 0);
        return sum;
    }
    
    public void dfs(TreeNode node, int ssf){
        if(node == null){
            return;
        }
        if(node.left == null && node.right == null){
            sum += 10*ssf + node.val;
            return;
        }
        int num = 10*ssf + node.val;
        dfs(node.left, num);
        dfs(node.right, num);
    }
}