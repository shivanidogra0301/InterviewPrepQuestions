package LinkedList;

public class duplicateNode2 {
      /* ek dummy node bnaenge ans uske next ko potential ans man k chlenge uski val ko age vale
    node s compare krenge or ek flag le lenge, ki agr uske aagi vali node same h, to mtlb ye hmara ans ni h, so simply itr k next ko hm uss node pe point kr demge jahan ni value h
    for eg<  1,1,1,2 h, to phle itr.next is pointing to 1, then we check next value same h
    agr h, to ab itr.next point to 2,fr usko check krenge, agr flag false h, mtlb value
    repeat nhi hui, to simply itr = itr.next krdenge mtlv vo node dummy list m add hogyi
    */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);
        ListNode itr = dummy;
        
        // to handle first case it could be a potential node
        itr.next = head; 
        cur = cur.next;
        
        while(cur != null){
            boolean flag = false;
            while(cur!= null && itr.next.val == cur.val){
                flag = true;
                cur = cur.next;
            }
            if(flag){
                // repeated value present
                itr.next = cur;
            }
            else{
                itr = itr.next;
            }
            // agr andr vale loop ne null de dia hoga to use case m check krna pdega
            if(cur!= null)
                cur = cur.next;
        }
        return dummy.next;
        
    }
}
