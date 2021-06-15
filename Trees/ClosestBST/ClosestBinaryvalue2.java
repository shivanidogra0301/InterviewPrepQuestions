package Trees.ClosestBST;

import java.util.LinkedList;
import java.util.List;

public class ClosestBinaryvalue2 {
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
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        traversal(root,target,k,ans);
        return ans;
    }

    public static void traversal(TreeNode root, double target, int k,LinkedList<Integer> ans){
        if(root == null){
            return;
        }
        traversal(root.left,target,k,ans);
        //sorted order window m phla element weak hoga usko compare kralenge
        if(ans.size() < k){
            ans.addLast(root.val);
        }
        else{
        
            if(Math.abs(root.val - target) < Math.abs(ans.peekFirst() - target)){
                ans.removeFirst();
                ans.addLast(root.val);
            }
            else{
                return;
            }
        }


        traversal(root.right,target,k,ans);
    }
}
