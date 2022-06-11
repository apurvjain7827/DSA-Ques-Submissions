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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        if(root != null){
            al.add(root.val);
            ans.add(al);
            qu.add(root);
        }
        
        while(qu.size() > 0){
            int size = qu.size();
            List<Integer> x = new ArrayList<>();
            while(size != 0){
                TreeNode node = qu.remove();
                if(node.left != null){
                    qu.add(node.left);
                    x.add(node.left.val);
                }
                if(node.right != null){
                    qu.add(node.right);
                    x.add(node.right.val);
                }
                
                size--;
            }
            if(x.size() > 0)
            ans.add(x);
        }
        return ans;
    }
}