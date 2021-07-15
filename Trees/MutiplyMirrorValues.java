package Trees;

public class MutiplyMirrorValues {
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
    long ans;
    int mod = 1000000007;
    public long imgMultiply(Node root)
    {   ans = root.data * root.data;
        Multiply(root.left,root.right);
        return ans%mod;
    }
    public void Multiply(Node root1, Node root2){
        if(root1 == null ||  root2 == null){
            return ;
        }
        ans+= root1.data * root2.data;
        Multiply(root1.left,root2.right);
        Multiply(root1.right, root2.left);
       
    }
}
