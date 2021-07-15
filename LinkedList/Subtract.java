package LinkedList;

public class Subtract {
 static   class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}
    static Node removepaddingzero(Node head){
        if(head == null){
            return null;
        }
        Node c = head;
        
        while(c != null && c.data == 0){
            c = c.next;
        }
        return c;
    }
        static Node subLinkedList(Node l1, Node l2)
        {   l1 = removepaddingzero(l1);
            l2 = removepaddingzero(l2);
            int len1 = length(l1);
            int len2 = length(l2);
            
            if(len1 == len2){
                Node c1 = l1;
                Node c2 = l2;
                int smaller = 0;
                while(c1 != null){
                    if(c1.data != c2.data){
                        if(c1.data < c2.data){
                            smaller = 1;
                            break;
                        }
                        else{
                            smaller = 2;
                            break;
                        }
                    }
                    c1 = c1.next;
                    c2 = c2.next;
                }
                if(smaller == 0){
                    return new Node(0);
                }
                else if(smaller == 1){
                    return subtract(l2,l1);
                }
                else{
                    return subtract(l1,l2);
                }
            }
            else if(len1 < len2){
                return subtract(l2,l1);
            }
            else{
                return subtract(l1,l2);
            }
        }
        
        static int length(Node l){
            int len = 0;
            while(l != null){
                l = l.next;
                len++;
            }
            
            return len;
        }
        
        public static Node subtract(Node l1, Node l2){
            if(l2 == null){
                return l1;
            }
            Node dummy  = new Node(-1);
            Node prev = dummy;
            Node nl1 = reverse(l1);
            Node nl2 = reverse(l2);
            
            Node c1 = nl1;
            Node c2 = nl2;
            int b = 0;
            
            while(c1 != null){
                int num1 = (c1 == null)? 0 : c1.data;
                int num2 = (c2 == null)? 0 : c2.data;
                
                int diff = num1 - num2 + b;
                
                if(diff < 0){
                    diff += 10;
                    b = -1;
                }
                else{
                    b = 0;
                }
                
                Node node = new Node(diff);
                prev.next = node;
                prev = node;
                
                c1 = c1.next;
                if(c2 != null)
                c2 = c2.next;
                
            }
            dummy = dummy.next;
            dummy =  reverse(dummy);
            dummy = removepaddingzero(dummy);
            return dummy;
        }
        
        public static Node reverse(Node head){
            if(head== null || head.next == null){
                return head;
            }
            
            Node prev = null;
            Node cur = head;
            Node forw = null;
            
            while(cur != null){
                forw = cur.next;
                
                cur.next = prev;
                prev = cur;
                cur = forw;
            }
            return prev;
        }
        
}
