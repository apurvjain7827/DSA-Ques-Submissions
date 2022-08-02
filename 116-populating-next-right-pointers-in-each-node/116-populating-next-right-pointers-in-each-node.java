/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node star = root;
        Node hash = root;
        while(star != null){
            while(hash != null){
                if(hash.left != null){
                    hash.left.next = hash.right;
                }
                if(hash.left != null && hash.next != null){
                    hash.right.next = hash.next.left;
                }
                
                hash = hash.next;
            }
            star = star.left;
            hash = star;
        }
        return root;
    }
}