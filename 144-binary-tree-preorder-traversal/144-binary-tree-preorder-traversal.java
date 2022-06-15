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
        int state;
        pair(){}
        pair(TreeNode node, int state){
            this.node = node;
            this.state = state;
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null){
            //List<Integer> base = ;
            return new ArrayList<>();
        }
        List<Integer> pre = new ArrayList<>();
        Stack<pair> st = new Stack<>();
        st.push(new pair(root, 0));
        while(st.size() != 0){
            pair curr = st.peek();
            if(curr.state == 0){
                pre.add(curr.node.val);
                curr.state++;
            }
            else if(curr.state == 3){
                st.pop();
            }
            else{
                if(curr.state == 1 && curr.node.left != null){
                    st.push(new pair(curr.node.left, 0));
                }
                else if(curr.state == 2 && curr.node.right != null){
                    st.push(new pair(curr.node.right, 0));
                }
                curr.state++;
            }
        }
        return pre;
    }
}