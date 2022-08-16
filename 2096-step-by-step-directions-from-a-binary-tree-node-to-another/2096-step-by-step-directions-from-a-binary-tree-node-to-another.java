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
        int data;
        char path;
        pair(){}
        pair(int data, char path){
            this.data = data;
            this.path = path;
        }
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue){
        ArrayList<pair> al1 = dfs(root, startValue, 'A');
        ArrayList<pair> al2 = dfs(root, destValue, 'A');
        int i = al1.size() - 1;
        int j = al2.size() - 1;
        while(i >= 0 && j >= 0){
            if(al1.get(i).data != al2.get(j).data){
                break;
            }
            i--;
            j--;
        }

        String ret = "";
        while(i >= 0){
            ret += "U";
            if(al1.get(i).data == startValue){
                break;
            }
            i--;
        }
        while(j >= 0){
            ret += al2.get(j).path;
            if(al2.get(j).data == destValue){
                break;
            }
            j--;
        }
        return ret;
    }
    
    public ArrayList<pair> dfs(TreeNode root, int num, char path){
        if(root == null){
            return new ArrayList<>();
        }
        if(root.val == num){
            ArrayList<pair> base = new ArrayList<>();
            base.add(new pair(num, path));
            return base;
        }
        
        ArrayList<pair> left = dfs(root.left, num, 'L');
        ArrayList<pair> right = dfs(root.right, num, 'R');
        if(left.size() > 0){
            left.add(new pair(root.val, path));
            return left;
        }
        else if(right.size() > 0){
            right.add(new pair(root.val, path));
            return right;
        }
        return new ArrayList<>();
    }
}