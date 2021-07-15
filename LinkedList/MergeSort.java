package LinkedList;

public class MergeSort {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode mid = mid(head);
        ListNode nhead = mid.next;
        mid.next = null;
        
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(nhead);
        
        return mergeTwoLists(l1,l2);
    }
    
     public static ListNode mid(ListNode head){
        if(head == null || head.next != null){
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    
     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return (l1 != null) ? l1 : l2;
        }
        ListNode l1p = l1; //list1 pointer
        ListNode l2p = l2; //list2 pointer
        
        
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(l1p != null && l2p != null){
            if(l1p.val < l2p.val){
                prev.next = l1p;
                l1p = l1p.next;
            }
            else{
                prev.next = l2p;
                l2p = l2p.next;
            }
            prev = prev.next;
        }
        if(l1p != null){
            prev.next = l1p;
        }
        else{
            prev.next = l2p;
        }
        dummy = dummy.next;
        return dummy;
    }
}
