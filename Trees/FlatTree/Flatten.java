package Trees.FlatTree;

public class Flatten {
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
    public void flatten(TreeNode root) {
        TreeNode tail = flatt(root);
        
    }
    public TreeNode flatt(TreeNode root){
        if(root == null){ 
            return null;
        }
        //will flat left subtree and uski tail return krega same with right
        TreeNode lefttail = flatt(root.left);
        TreeNode righttail = flatt(root.right);
        
    //agr dono null ni h, to phle root k left ko right m jodna h
        if(root.left != null && root.right != null){
            TreeNode rightsubtree = root.right; // save krlo ek var m
            root.right = root.left; // to phle root k left ko right m jodna h
            root.left = null; //left null krna h
            lefttail.right = rightsubtree; // ab rightsubtree left ki tail k right m judega
            return righttail; //new tree ki tail righttail hogi
        }
         if(root.left != null){
             //agr left null ni h and right null h, to simply lefi ko right m daldo
            root.right = root.left;
            root.left = null;
            return lefttail;
        }
         if(root.right != null){
             //nothing to update in tree just righttail bhejdo
                return righttail;
        }
        
        // if both are null, then tail vo khud hi hoga
        return root;
            
        
}
}
