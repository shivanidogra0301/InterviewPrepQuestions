package LinkedList;

class IntersectionPoint{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
      /* first method, first connnect the tail of either head A or heab(both are same if intersected) with headA, it will make a cycle in ll, no we just want to find the
    starting node of the cycle which is the answer
    for that, fist move slow and fast with 1:2 speed and find the point where they intersect
    now again start slow from heada and fast from the same position and now when se ther intersect is the inetrsection point*/ 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        
        //modify
        ListNode tail = headA;
        while(tail.next != null){
            tail = tail.next;
        }
        tail.next = headB;
        
        ListNode ans = findstartingpoint(headA);
        
        //unmodify
        tail.next = null;
        
        return ans;
    }
    
    public static ListNode findstartingpoint(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        
        //if there is no cycle present
        if(slow != fast){
            return null;
        }
        
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
        
    }
}