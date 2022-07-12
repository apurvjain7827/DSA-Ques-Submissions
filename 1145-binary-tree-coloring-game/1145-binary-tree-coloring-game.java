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
    public int getS(TreeNode node){
        if(node == null){
            return 0;
        }
        int ls = getS(node.left);
        int rs = getS(node.right);
        return ls + rs + 1;
    }
    public TreeNode getNode(TreeNode node, int tar){
        if(node == null){
            return null;
        }
        if(node.val == tar){
            return node;
        }
        TreeNode ln = getNode(node.left, tar);
        TreeNode rn = getNode(node.right, tar);
        if(ln != null){
            return ln;
        }
        else if(rn != null){
            return rn;
        }
        else{
            return null;
        }
    }
    
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        // if(root == null){
        //     return false;
        // }
        TreeNode node = getNode(root, x);
        int ls = getS(node.left);
        int rs = getS(node.right);
        int us = n - (ls + rs + 1);
        int max = Math.max(us, Math.max(ls, rs));
        if(max > n - max){
            return true;
        }
        return false;
    }
}