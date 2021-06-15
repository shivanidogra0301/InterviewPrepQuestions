package Trees;

class isBsT{
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
    public boolean isValidBST(TreeNode root) {
            return valid(root,null,null);
    }
    //long because given constraints will overflow the int range
    public boolean valid(TreeNode root,Integer min, Integer max){
        if(root == null){
            return true;
        }
    // it will check if root node is present in range if not then no need to check further
        if((max != null && root.val >= max) || (min != null && root.val <= min)){
            return false;
        }
        // check for left and right subtree
        boolean left = valid(root.left,min,root.val);
        boolean right = valid(root.right,root.val,max);
        
        return left && right;
    }
}