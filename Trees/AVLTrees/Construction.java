package Trees.AVLTrees;

public class Construction {
    static class Node{
        int data;
        Node left,right;
        int height;
        Node(int d)
        {
            data=d;
            left=right=null;
            height = 1;
        }
    }
    public  Node insertToAVL(Node node,int data)
    {
        if(node == null){
            Node root = new Node(data);
            return root;
        }
        
        if(node.data > data){
            node.left = insertToAVL(node.left,data);
        }
        else if(node.data < data){
            node.right = insertToAVL(node.right,data);
        }
        
        int lh = height(node.left);
        int rh = height(node.right);
        node.height = Math.max(lh,rh)+1;
        
        int diff = lh - rh;
        Node newroot = node;
        if(diff > 1 && node.left.data > data){ 
            /* LL
            diff > 1 means left ki height zyada h,mtlb node k  left subtree m pkke se add hua h, pr left k left ya right
            m hua h , isko check krne k liye dekha node.left.data > data se bda h, to mtlb uske left m dla h */
            
            //so rr rotation hoegi
            newroot = rightrotation(node);
            
        }
        else if(diff > 1 && node.left.data < data){
            // LR
            node.left = leftrotation(node.left);
            newroot = rightrotation(node);
            
        }
        else if(diff < -1 && node.right.data < data){
            //RR
            newroot = leftrotation(node);
            
            
        }
        else if(diff < -1 && node.right.data > data){
            //RL
            node.right = rightrotation(node.right);
            newroot = leftrotation(node);
        }
        
        return newroot;
        
    }
    
    public int height(Node a){
        if(a == null){
            return 0;
        }
        return a.height;
    }
    public Node leftrotation(Node a){
        /* left rotate mtlb right vala root bnega, so b k left m a aaega, to jo b.left m phle se store the usko nyi position
            milegi, i.e a.right
        */
        Node b = a.right; 
        Node t2 = b.left;
        
        Node root = b;
        b.left = a;
        a.right = t2;
        
        a.height = Math.max(height(a.left),height(a.right))+1;
        b.height = Math.max(height(b.left),height(b.right))+1;
        
        
        return root;
    }
    
    public Node rightrotation(Node a){
        Node b = a.left;
        Node t2 = b.right;
        
        Node root = b;
        b.right = a;
        a.left = t2;
        
        a.height = Math.max(height(a.left),height(a.right))+1;
        b.height = Math.max(height(b.left),height(b.right))+1;
        
        return root;
    }
    
}
