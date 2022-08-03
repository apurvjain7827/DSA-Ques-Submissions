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
        if(root == null){
            return root;
        }
        if(root.left == null && root.right == null){
            return root;
        }
        Node curr = root;
        Node head = null;
        Node tail = null;
        if(curr.left != null){
            head = curr.left;
            tail = curr.left;
        }
        else if(curr.right != null){
            head = curr.right;
            tail = curr.right;
        }
        while(curr != head){
            while(curr != null){
                if(curr.right != null && head != curr.right){
                    tail.next = curr.right;
                    tail = curr.right;
                }
                if(curr.next != null && curr.next.left != null && head != curr.next.left){
                    tail.next = curr.next.left;
                    tail = curr.next.left;
                }
                curr = curr.next;
            }
            curr = head;
            Node temp = curr;
            
            while(temp != null){
                if(temp.left != null){
                    head = temp.left;
                    tail = temp.left;
                    break;
                }
                if(temp.right != null){
                    head = temp.right;
                    tail = temp.right;
                    break;
                }
                temp = temp.next;
            }
        }
        return root;
    }
}