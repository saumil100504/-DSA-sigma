/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if( head == null){
            return head;
        }
        Node curr = head;
        while(curr != null){
            if(curr.child != null){
              //flatten the child nodes
              Node next = curr.next;
              Node child = flatten(curr.child);
           //curr node with child
              curr.next = child;
              child.prev = curr;
            // remove child pointer
             curr.child = null;
            //find the tail of the flattened list
             Node tail = child;

             while(tail.next != null){
                tail = tail.next;
             }
            // connect tail with the child node
             if(next != null){
                tail.next = next;
                next.prev = tail;
             }
              
            }
            curr = curr.next;
        }
        return head;
    }
}