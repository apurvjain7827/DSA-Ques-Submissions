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
        int lov;
        int loh;
        pair(){}
        pair(TreeNode node, int lov, int loh){
            this.node = node;
            this.lov = lov;
            this.loh = loh;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<pair> qu = new LinkedList<>();
        qu.add(new pair(root, 0, 0));
        PriorityQueue<pair> pq = new PriorityQueue<>((a,b)->{
            if(a.loh == b.loh && a.lov == b.lov){
                return a.node.val - b.node.val;
            }
            else if(a.loh == b.loh){
                return a.lov - b.lov;
            }
            else
            return a.loh - b.loh;
        });
        while(qu.size() != 0){
            pair rem = qu.remove();
            pq.add(rem);
            if(rem.node.left != null){
                qu.add(new pair(rem.node.left, rem.lov + 1, rem.loh - 1));
            }
            if(rem.node.right != null){
                qu.add(new pair(rem.node.right, rem.lov + 1, rem.loh + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while(pq.size() > 0){
            List<Integer> inner = new ArrayList<>();
            pair rem = pq.remove();
            inner.add(rem.node.val);
            while(pq.size() != 0 && pq.peek().loh == rem.loh){
                rem = pq.remove();
                // if(pq.size() != 0 && pq.peek().lov == rem2.lov && rem2.loh == pq.peek().loh){
                //     pair remS = pq.remove();
                //     if(remS.node.val < rem2.node.val){
                //         inner.add(remS.node.val);
                //         inner.add(rem2.node.val);
                //     }
                //     else{
                //       inner.add(rem2.node.val);
                //        inner.add(remS.node.val);
                //     }
                // }
                //else{
                inner.add(rem.node.val);
                //}
                //rem = rem2;
            }
            ans.add(inner);
        }
        return ans;
    }
}