package Trees.Traversals_iterative;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Postorder {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
       
        while(root != null){
            if(root.right == null){ //left does not exist to ans m add kro or right m chle jao
                list.add(root.val);
                root = root.left;
            }
            else{
                TreeNode rp1 = root.right; //root plus one(left subtree ka rightmost nikalna h)
                while(rp1.left != null && rp1.left != root){
                    rp1 = rp1.left;
                }
                if(rp1.left == null){ //first time visit hua h
                    list.add(root.val);
                    rp1.left = root; //connect rightmost to root
                    root = root.right;
                }
                else{ //second time visit hua h
                    //to ans m add ni hoga
                    rp1.left = null;
                    root = root.left;
                    
                }
            }
        }
    Collections.reverse(list);
       return list;

    }
}
