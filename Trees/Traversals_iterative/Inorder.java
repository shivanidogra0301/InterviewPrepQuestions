package Trees.Traversals_iterative;

import java.util.ArrayList;
import java.util.List;

public class Inorder {
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
       
        while(root != null){
            if(root.left == null){ //left does not exist to ans m add kro or right m chle jao
                list.add(root.val);
                root = root.right;
            }
            else{
                TreeNode rp1 = root.left; //root plus one(left subtree ka rightmost nikalna h)
                while(rp1.right != null && rp1.right != root){
                    rp1 = rp1.right;
                }
                if(rp1.right == null){ //first time visit hua h
                    list.add(root.val);
                    rp1.right = root; //connect rightmost to root
                    root = root.left;
                }
                else{ //second time visit hua h
                    //to ans m add ni hoga
                    rp1.right = null;
                    root = root.right;
                    
                }
            }
        }
       return list;
   }
}
