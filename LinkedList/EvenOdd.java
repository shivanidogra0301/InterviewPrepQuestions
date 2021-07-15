package LinkedList;

public class EvenOdd {
     /* divide node into odd indices and even idices an then merge them */

     public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
     public ListNode oddEvenList(ListNode head) {
        if(head== null || head.next == null){
            return head;
        }
        ListNode even = new ListNode(-1);
        ListNode odd = new ListNode(-1);
        ListNode ep = even;
        ListNode op = odd;
        int i= 1;
        while(head != null){
            if(i%2 == 0){
                ep.next = head;
                ep = ep.next;
            }
            else{
                op.next = head;
                op = op.next;
            }
            i++;
            head = head.next;
        }
        ep.next = null;
        op.next = even.next;
        return odd.next;
    }
}
