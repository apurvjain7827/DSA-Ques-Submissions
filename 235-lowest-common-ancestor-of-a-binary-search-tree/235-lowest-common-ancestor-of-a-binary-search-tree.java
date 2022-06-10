/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> pst = new LinkedList<>();
        TreeNode pNode = root;
        while(pNode != null){
            if(pNode.val < p.val){
                pst.add(pNode);
                pNode = pNode.right;
            }
            else if(pNode.val > p.val){
                pst.add(pNode);
                pNode = pNode.left;
            }
            else{
                pst.add(pNode);
                break;
            }
        }
        Queue<TreeNode> qst = new LinkedList<>();
        TreeNode qNode = root;
        while(qNode != null){
            if(qNode.val < q.val){
                qst.add(qNode);
                qNode = qNode.right;
            }
            else if(qNode.val > q.val){
                qst.add(qNode);
                qNode = qNode.left;
            }
            else{
                qst.add(qNode);
                break;
            }
        }
        TreeNode ans = null;
        while(pst.peek() == qst.peek()){
            ans = pst.remove();
            qst.remove();
        }
        
        return ans;
    }
}