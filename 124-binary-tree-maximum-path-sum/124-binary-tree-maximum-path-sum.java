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
        maxRoot2Node(root);
        return ans;
    }
    
    // public void dfs(TreeNode node){
    //     if(node == null)
    //         return;
    //     int lft = maxRoot2Node(node.left);
    //     int ryt = maxRoot2Node(node.right);
    //     int sum = node.val + Math.max(lft, 0) + Math.max(ryt, 0);
    //     if(sum>ans){
    //         ans = sum;
    //     }
    //     dfs(node.left);
    //     dfs(node.right);
    // }
    
    public int maxRoot2Node(TreeNode node){
        if(node == null){
            return 0;
        }
        int left = maxRoot2Node(node.left);
        int right = maxRoot2Node(node.right);
        int sum = Math.max(left, 0) + Math.max(right, 0) + node.val;
        if(sum > ans)
            ans = sum;
        return Math.max(Math.max(left, right), 0) + node.val;
    }
}