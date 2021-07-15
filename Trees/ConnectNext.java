package Trees;

public class ConnectNext {
    static class Node{
        int data;
        Node left,right;
        public Node next;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Node node = root;
        while(node.left != null){
            Node temp = node;
            while(temp != null){
                temp.left.next = temp.right;
                
                if(temp.next != null){
                    temp.right.next = temp.next.left;
                }
                temp = temp.next;
            }
            node = node.left;
        }
        return root;
    }
}
