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
    public TreeNode construct(int stP, int endP, int stI, int endI, int[] pre, int[] in){
        if(stP >= pre.length || stP < 0 || endP >= pre.length || endP < 0 || stP>endP){
            return null;
        }
        if(stP == endP){
            return new TreeNode(pre[stP]);
        }
        int idx = -1;
        for(int i=stI; i<=endI; i++){
            if(in[i] == pre[stP]){
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(pre[stP]);
        root.left = construct(stP + 1, stP + (idx - stI), stI, idx - 1, pre, in);
        root.right = construct(stP + (idx - stI) + 1, endP, idx + 1, endI, pre, in);
        return root;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(0, preorder.length - 1, 0, preorder.length - 1, preorder, inorder);
    }
}