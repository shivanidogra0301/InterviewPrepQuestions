package Trees.Views;

import java.util.ArrayList;
import java.util.List;

public class RightView {
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
           if(root.left == null){
               list.add(root.val);
               root = root.right;
           }
           else{
               TreeNode rp1 = root.left;
               while(rp1.right != null && rp1.right != root){
                   rp1 = rp1.right;
               }
               
               if(rp1.right == null){
                   list.add(root.val);
                   rp1.right = root;
                   root = root.left;
               }
               else{
                   rp1.right = null;
                   root = root.right;
               }
           }
       }
       
       return list;
   }
}
