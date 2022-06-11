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
        TreeNode node;
        int height;
        boolean ans;
        pair(){}
        pair(TreeNode node, int height, boolean ans){
            this.node = node;
            this.height = height;
            this.ans = ans;
        }
    }
    
    public pair func(TreeNode root){
        if(root == null){
            return new pair(null, 0, true);
        }
        pair leftAns = func(root.left);
        pair rightAns = func(root.right);
        pair myPair = new pair();
        myPair.node = root;
        myPair.height = Math.max(leftAns.height, rightAns.height) + 1;
        int a = leftAns.height;
        int b = rightAns.height;
        if(leftAns.ans == true && rightAns.ans == true && a-b <= 1 && a-b >= -1){
            myPair.ans = true;
        }
        else{
            myPair.ans = false;
        }
        return myPair;
    }
    
    public boolean isBalanced(TreeNode root) {
        pair myAns = func(root);
        return myAns.ans;
    }
}