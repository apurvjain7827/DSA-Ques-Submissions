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
    public TreeNode deleteNode(TreeNode root, int key) {
        // helper(root, key);
        return helper(root, key);
    }
    public TreeNode helper(TreeNode root, int key){
        if(root == null)
            return null;
        if(root.val == key){
            if(root.left == null && root.right == null)
                return null;
            if(root.left == null)
                return root.right;
            if(root.right == null)
                return root.left;
            TreeNode temp = root.left;
            while(temp.right != null){
                temp = temp.right;
            }
            root.val = temp.val;
            root.left = helper(root.left, temp.val);
        }
        root.left = helper(root.left, key);
        root.right = helper(root.right, key);
        return root;
    }
}