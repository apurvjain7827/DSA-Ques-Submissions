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
    public class pair{
        int h;
        int d;
        pair(){}
        pair(int h, int d){
            this.h = h;
            this.d = d;
        }
    }
    public pair func(TreeNode root){
        if(root == null){
            return new pair(-1, 0);
        }
        pair leftPair = func(root.left);
        pair rightPair = func(root.right);
        pair myPair = new pair();
        myPair.h = Math.max(leftPair.h, rightPair.h) + 1;
        myPair.d = Math.max(leftPair.h + rightPair.h + 2 , Math.max(leftPair.d , rightPair.d));
        return myPair;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return func(root).d;
    }
}