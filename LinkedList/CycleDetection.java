package LinkedList;

public class CycleDetection {
     /* cycle detection m agr slow or fast ko diffrent speed se chlaemge to hmesha agr
    cycle present h to vo intersect krenge and ans mil jaenge but sbse km time tb hoga
    jb ek ki speed 1 ho and dusre ki 2x. y/x != 1 */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}
