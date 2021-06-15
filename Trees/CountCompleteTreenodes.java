package Trees;

public class CountCompleteTreenodes {
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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int lh = getheightleft(root); //runs o(h)times
        int rh = getheightright(root);
        
        if(lh == rh){ 
            // this condition will surely be true in either left or right(so half recursion calls will be discarded)
            return ((1<<lh) - 1);
        }
        
        /*this code if written independently the complexity would be o(n) */
        int lcount = countNodes(root.left);
        int rcount = countNodes(root.right);
    
        return lcount + rcount + 1;
        
    }
    public int getheightleft(TreeNode root){
        int cnt = 1;
        while(root.left != null){
            cnt++;
            root = root.left;
        }
        return cnt;
    }
    public int getheightright(TreeNode root){
        int cnt = 1;
        while(root.right != null){
            cnt++;
            root = root.right;
        }
        return cnt;
    }
}
