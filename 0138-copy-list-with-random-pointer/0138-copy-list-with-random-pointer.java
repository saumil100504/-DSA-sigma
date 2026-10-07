/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        HashMap<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val);
       //storing the mapping for the head node
        map.put(head,newHead);

        Node oldTemp = head.next;
        Node newTemp = newHead;

        //step-1 create all new Nodes and map them to thier corresponding nodes

        while(oldTemp != null){
            Node copyNode = new Node(oldTemp.val);
            map.put(oldTemp, copyNode);
            newTemp.next = copyNode;
            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }
        
        // step -2 for random and next connections
        oldTemp = head;
        newTemp = newHead;

        while(oldTemp != null){
            newTemp.random = map.get(oldTemp.random);

            oldTemp = oldTemp.next;
            newTemp = newTemp.next;
        }
          return newHead;
    }
}