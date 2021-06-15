package Trees;

public class DeleteNodesInBST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        
        if(root.val > key){  
            // left subtree update hoke iske left m lg jaye
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key){ 
            // right subtree update hoke iske right m lg jaye purana pointer ht jaega
            root.right = deleteNode(root.right,key);
        }
        else{ 
            // ab equal h to delete hoga
            root = delete(root);
        }
        return root;
    }
    
    public TreeNode delete(TreeNode root){
        //node that going to be delete is leaf node so simply return null
        if(root.left == null && root.right == null){
            return null;
        }
        
        //right null then return left
        if(root.right == null){
            return root.left;
        }
        if(root.left == null){
            return root.right;
        }
        
        //when both are not null we find left subtree ka rightmost element that is greatest element uske right m hm right subtree jod denge or uss left subtree ko bhej denge
        TreeNode leftnode = root.left;
        while(leftnode.right != null){
            leftnode = leftnode.right;
        }
        //this loop gives greatest element in left subtree
        //uske right m node jisko delete krre h uska right subtree jod denge
        leftnode.right = root.right;
        //vo updated left subtree jisme right subtree ki value b dl chuki h vo return kr denge
        return root.left;
    }
    
}
