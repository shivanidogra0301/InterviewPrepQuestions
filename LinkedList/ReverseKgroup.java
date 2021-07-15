package LinkedList;

public class ReverseKgroup {
       /* time = o(n), space = o(1) */

       public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

       static ListNode th;
       static ListNode tt;
       public ListNode reverseKGroup(ListNode head, int k) {
           if(head == null || head.next == null || k== 0) return head;
           ListNode oh = null;
           ListNode ot = null;
           ListNode cur = head;
           ListNode forw = null;
           int len = length(head);
           
           // reverse krne k bad remaining list ki length atleast k honi chaiye
          while(len >= k){
              int tk = k;
              th = null;
              tt = null;
              while(tk-- > 0){
                  //backup
                  forw = cur.next;
                  
                  //links changed
                  cur.next = null;
                      
                   // add this node to thead   
                  addFirst(cur);
                  
                  cur = forw;
              }
              len -= k;
              // adding reverse list of k length to the last of overall list
              if( oh == null){
                  oh = th;
                  ot = tt;
              }
              else{
                  ot.next = th;
                  ot = tt;
              }
              
          }
           //if there is some node present in list whose len is less than k
           ot.next = cur;
           
           return oh;
       }
      
       
       public static int length(ListNode head){
           int len = 0;
           ListNode cur = head;
           while(cur!= null){
               len++;
               cur = cur.next;
           }
           
           return len;
       }
       
       public void addFirst(ListNode node){
           if(th == null){
               th = tt = node;
               return;
           }
           
           node.next = th;
           th = node;
       }
}
