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
    int max;
    HashMap<Integer, Integer> map;
    public int[] findMode(TreeNode root) {
        max = 0;
        map = new HashMap<>();
        helper(root);
        int freq = 0;
        for(int key : map.keySet()){
            if(map.get(key) == max){
                freq++;
            }
        }

        int[] ans = new int[freq];
        int ind = 0;
        for(int key : map.keySet()){
            if(map.get(key) == max){
                ans[ind] = key;
                ind++;
            }
        }

        return ans;
    }

    public void helper(TreeNode node){
        if(node == null){
            return;
        }
        map.put(node.val, map.getOrDefault(node.val, 0) + 1);
        max = Math.max(map.get(node.val), max);
        helper(node.left);
        helper(node.right);
    }
}