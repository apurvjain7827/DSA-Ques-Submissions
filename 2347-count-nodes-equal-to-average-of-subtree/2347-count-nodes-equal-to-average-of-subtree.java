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
    int ans;
    public int[] helper(TreeNode node){
        if(node == null){
            return new int[]{0, 0};
        }

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int avg = (left[0] + node.val + right[0]) / (left[1] + 1 + right[1]);

        if(avg == node.val){
            ans++;
        }

        return new int[]{left[0] + node.val + right[0], left[1] + 1 + right[1]};
    }
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        helper(root);
        return ans;
    }
}