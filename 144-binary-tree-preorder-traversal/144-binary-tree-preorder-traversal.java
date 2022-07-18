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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> retVal = new ArrayList<>();
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                retVal.add(curr.val);
                curr = curr.right;
            }
            else{
                TreeNode prep = curr.left;
                while(prep.right != null && prep.right != curr){
                    prep = prep.right;
                }
                if(prep.right == null){
                    retVal.add(curr.val);
                    prep.right = curr;
                    curr = curr.left;
                }
                else{
                    prep.right = null;
                    curr = curr.right;
                }
            }
        }
        return retVal;
    }
}