package Trees.ClosestBST;

public class ClosestBinaryValue {
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
    TreeNode ans; 
    public int closestValue(TreeNode root, double target) {
        // write your code here
        ans = root;

        while(root != null){
            if(Math.abs(root.val - target) < Math.abs(ans.val - target)){
                    ans = root;
            }
            if(root.val == target){
                break;
            }
            else if(root.val < target){
                root = root.right;
                
            }
            else{
                root = root.left;
            }
        }
        return ans.val;

    }
}
