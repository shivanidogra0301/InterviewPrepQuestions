package LinkedList;

class ReverseLLusingAddFirst{
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        ListNode frw = head;
        ListNode nhead = null;
        ListNode ntail = null;
        while(cur != null){
            //backup
            frw = cur.next;
            
            //adfirst
            if(ntail == null){
                ntail = cur;
            }
            cur.next = nhead;
            nhead = cur;
                
            //move forward
            cur = frw;
        }
        return nhead;
    }
}