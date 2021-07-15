package LinkedList;

public class DeleteDuplicates {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode th = null;
        ListNode tt = null;
        
        
        ListNode cur = head;
        ListNode fw = null;
        while(cur != null){
            fw = cur.next;
            
            cur.next = null;

            
            if(th == null){
                th = tt = cur;
            }
            else{
                if(tt.val != cur.val){
                    tt.next = cur;
                    tt = cur;
                }
                
            }
            
            cur = fw;
        }
        return th;
    }
}
