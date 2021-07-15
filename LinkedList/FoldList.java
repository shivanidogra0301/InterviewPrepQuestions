package LinkedList;

public class FoldList {
     /* to fold the linked list 1-2-3-4-5 = 1-5-2-4-3, 
    step 1 find mid and break linkedlist from there 1-2-3    4-5 (3 is the mid)
    step 2 reverse second ll = 5-4
    step 3 take pointers on both linkedlist and add alternate value one ny one
    1-2-3  5-4  =  1-5-2-4-3 which is the answer
    time complexity = o(n)*/

    public class ListNode {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public void reorderList(ListNode head) {
        ListNode mid  = mid(head);
        ListNode nhead = mid.next; // head of partitioned list
        mid.next = null; // divide the list
        nhead = reverse(nhead); //return new head after reversing
        
        //now take pointers
        ListNode c1 = head;
        ListNode c2 = nhead;
        ListNode f1 = null;
        ListNode f2 = null;
        //srf c2 check kia cuz odd k case  c1 ki length zyda hogi and even m brabr
        while(c2 != null){
            //backup
            f1 = c1.next;
            f2 = c2.next;
            
            //links
            c1.next = c2;
            c2.next = f1;
            
            //move
            c1 = f1;
            c2 = f2;
        }
        
    }
    
    public static ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode forw = null;
        
        /* jb b hm list k pointers ko change kre to hmesha phle aage ki values ko
        point krne k liye ek pointer rkh le jisko backup khte h */
        while(cur != null){
            //backup
            forw = cur.next;
            
            //links change
            cur.next = prev;
            prev = cur;
             
            //move forward
            cur = forw;
        }
        
        return prev;
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
//unfold phle 1-4-2-3 = 1-2, 4-3 m divide krlo, 4-3 reversed = 3-4 then 1-2 k end m daldo 1-2-3-4
    public static void unfold(ListNode head) {
        if(head == null || head.next == null){
            return;
        }
        ListNode fhead = head; //first list head
        ListNode fp = fhead; // first list pointer
        
        ListNode shead = head.next;
        ListNode sp = shead;
        
        
        while(sp != null && sp.next != null){
            //backup
            ListNode fw = sp.next;
            
            //links
            fp.next  = fw;
            sp.next = fw.next;
            
            fp = fp.next;
            sp = sp.next;
            
        }
        fp.next = null;
        shead = reverse(shead);
        fp.next = shead;
    }
}
