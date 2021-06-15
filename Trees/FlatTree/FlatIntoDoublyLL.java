package Trees.FlatTree;

public class FlatIntoDoublyLL {
    class Node{
        int data;
        Node left,right;
        Node(int d){
            data=d;
            left=right=null;
        }
    }
    Node bTreeToClist(Node root)
    {
        //this function will return the tail of created ll and we have to return head
        Node tail = flatt(root);
        return tail.right;

        //if we want to conert into non circular, then just change the pointers of head left and tail right
        /* Node head = tail.right;
        head.left = null;
        tail.right = null */
    }
     public Node flatt(Node root){
        if(root == null){ 
            return null;
        }
        
        Node lefttail = flatt(root.left);
        Node righttail = flatt(root.right);
        
    
        if(root.left != null && root.right != null){
            /*convert the curr node into doubly ll and send first send left doubly ll ki tail
            and newly created cur node ll to merge them and after that updated ll and right ll is 
            merged so that we get the linkedlist in inorder*/
            root.left = root;
            root.right = root;
            Node t1 = add(lefttail,root);
            Node t2 = add(t1,righttail);
            return t2;
        }
         if(root.left != null){
             // here we just need to merge left and curr root ll 
            root.left = root;
            root.right = root;
            Node tail = add(lefttail,root);
            return tail;
        }
         if(root.right != null){
            root.left = root;
            root.right = root;
            Node tail = add(root,righttail);
            return tail;
        }
        
        // if both are null, to merge ni krna just doubly bnake bhejdo
        root.left = root;
        root.right = root;
        return root;
            
        
}
    public Node add(Node t1, Node t2){
        Node h1 = t1.right;
        Node h2 = t2.right;
        t1.right = h2;
        h2.left = t1;
        t2.right = h1;
        h1.left = t2;
        return t2;
    }
}
