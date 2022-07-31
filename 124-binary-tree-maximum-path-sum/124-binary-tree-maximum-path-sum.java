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
    public int ans;
    
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    
    public void dfs(TreeNode node){
        if(node == null)
            return;
        int lft = maxRoot2Node(node.left);
        int ryt = maxRoot2Node(node.right);
        int sum = node.val + Math.max(lft, 0) + Math.max(ryt, 0);
        if(sum>ans){
            ans = sum;
        }
        dfs(node.left);
        dfs(node.right);
    }
    
    public int maxRoot2Node(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left != null && node.right != null){
            int left = maxRoot2Node(node.left);
            int right = maxRoot2Node(node.right);
            return node.val + Math.max(Math.max(0, left), Math.max(0, right));
        }
        else if(node.left != null){
            int left = maxRoot2Node(node.left);
            return node.val + Math.max(0, left);
        }
        else if(node.right != null){
            int right = maxRoot2Node(node.right);
            return node.val + Math.max(0, right);
        }
        else{
            return node.val;
        }
    }
}