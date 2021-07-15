package LinkedList;

public class Pallindromecheck {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
     /* again we have to compare first and last char of linkedlist without having tail
    so we first divide it in 2 parts and then iterate over both*/
    public boolean isPalindrome(ListNode head) {
        if(head.next == null){
            return true;
        }
        ListNode mid = mid(head);
        ListNode nhead = mid.next;
        nhead = reverse(nhead);
        
        ListNode c1 = head;
        ListNode c2 = nhead;

        
        while(c2 != null){
            if(c1.val != c2.val){
                return false;
            }
            c1 = c1.next;
            c2 = c2.next;
        }
        
        return true;
        
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
}
