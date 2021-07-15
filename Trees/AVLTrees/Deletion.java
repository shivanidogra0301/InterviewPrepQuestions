package Trees.AVLTrees;

public class Deletion {
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

    public static Node Max(Node node){
        if(node.right == null){
            return node;
        }
        return Max(node.right);
    }
    public Node deleteNode(Node node, int data){
        if(node == null){
            
            return null;
        }
        
        if(node.data > data){
            node.left = deleteNode(node.left,data);
        }
        else if(node.data < data){
            node.right = deleteNode(node.right,data);
        }
        else{
            if(node.left == null && node.right == null){
                return null;
            }
            else if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }
            else{
            Node rootp1 = node.left;
            while(rootp1.right != null){
                rootp1 = rootp1.right;
            }

            node.data = rootp1.data;
            node.left = deleteNode(node.left,rootp1.data);
            }

        }
        
        
        int lh = height(node.left);
        int rh = height(node.right);
        node.height = Math.max(lh,rh)+1;
        
        int diff = diffrence(node);
        Node newroot = node;
        if(diff > 1 && diffrence(node.left) >= 0){ 
            newroot = rightrotation(node);
            
        }
        else if(diff > 1 && diffrence(node.left) < 0){
            // LR
            node.left = leftrotation(node.left);
            newroot = rightrotation(node);
            
        }
        else if(diff < -1 && diffrence(node.right) <= 0){
            //RR
            newroot = leftrotation(node);
            
            
        }
        else if(diff < -1 && diffrence(node.right) > 0){
            //RL
            node.right = rightrotation(node.right);
            newroot = leftrotation(node);
        }
        
        return newroot;
        
    }
    public int diffrence(Node node){
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }
    
    
    public int height(Node a){
        if(a == null){
            return 0;
        }
        return a.height;
    }
    public Node leftrotation(Node a){
        
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
