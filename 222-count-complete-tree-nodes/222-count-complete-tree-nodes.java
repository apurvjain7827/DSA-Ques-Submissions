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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null){
            return 1;
        }
        if(root.right == null){
            return 2;
        }
        int lh = 0;
        TreeNode ln = root.left;
        while(ln != null){
            lh++;
            ln = ln.left;
        }
        int rh = 0;
        TreeNode rn = root.right;
        while(rn != null){
            rh++;
            rn = rn.right;
        }
        if(lh == rh){
            return (int)Math.pow(2, rh+1) - 1;
        }
        int lc = countNodes(root.left);
        int rc = countNodes(root.right);
        return lc + rc + 1;
    }
}