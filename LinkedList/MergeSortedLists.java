package LinkedList;

import java.util.PriorityQueue;

public class MergeSortedLists {
      /* ek dummy node bnalenge starting k liye taki jb dono ke first element compare
    honge to uss time prev kisi ko point krta rhna chaiye, kyuki agr prev null hoga
    to hm prev.next ko point ni kr paenge
    
    do pointer lenge l1p, l2p or prev jo prev sorted value pe point krega,and nyi node
    ko apne m add krta rhega
    
    */

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->{
            return a.val - b.val;
        });
        
        for(ListNode l : lists){
            if(l != null){
                pq.add(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while(pq.size() > 0){
            ListNode node = pq.remove();
            
            prev.next = node;
            prev = prev.next;
            node = node.next;
            if(node != null)
                pq.add(node);
        }
        
        return dummy.next;
    }
}
