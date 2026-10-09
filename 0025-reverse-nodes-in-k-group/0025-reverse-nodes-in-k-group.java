/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
     
     //dummy node before original node
     ListNode dummy = new ListNode(0,head);

     //node before group prev
     ListNode groupPrev = dummy;


     while(true){
        //find the kth node of the current group
        ListNode kth = getKth(groupPrev,k);
        
        if(kth == null){
            break;
        }

        //save the first node after this group

        ListNode groupNext = kth.next;

        //revrse the current group

        ListNode prev = groupNext;
        ListNode curr = groupPrev.next;

        while(curr != groupNext){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //connect the prev part to the new head
        ListNode temp = groupPrev.next;
        groupPrev.next = kth;

        groupPrev = temp;
      }
      return dummy.next; 
  }

  //find the kth node after groupPrev

  private ListNode getKth(ListNode groupPrev, int k){

    ListNode curr = groupPrev;

    for(int i = 0; i<k ; i++){
        curr = curr.next;

        if(curr == null){
            return null;
        }
    }
        return curr;
    }
  }