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
    public int idx;
    public TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, preorder);
    }
    public TreeNode construct(int min, int max, int[] preorder){
        if(idx >= preorder.length){
            return null;
        }
        if(preorder[idx] > min && preorder[idx] < max){
            TreeNode curr = new TreeNode(preorder[idx]);
            idx++;
            curr.left = construct(min, curr.val, preorder);
            curr.right = construct(curr.val, max, preorder);
            return curr;
        }
        return null;
    }
}