package Trees;

public class RecoverBST {
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
    TreeNode prev;
    TreeNode ans1;
    TreeNode ans2;
    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        ans1 = null;
        ans2 = null;
        findSwappedNodes(root);
        
        int temp = ans1.val;
        ans1.val = ans2.val;
        ans2.val = temp;
    }
    
    public  void findSwappedNodes(TreeNode root){
        if(root == null){
            return;
        }
        findSwappedNodes(root.left);
        if(ans1 == null && prev.val > root.val){
            ans1 = prev;
            ans2 = root;
        }
        else if( prev.val > root.val){
            ans2 = root;
            return;
        }
        
        prev = root;
        
        findSwappedNodes(root.right);
    }
}
