package Trees;

public class MaxPathSum {
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
    int max ;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        int temp = maxSum(root);
        return max;
    }
    
    public int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int lpath = maxSum(root.left); //linear path of left
        int rpath = maxSum(root.right); //linear path of right
        
        int maxleftright = Math.max(lpath,rpath); //two candidates left and right covered
        int linearmax = root.val + maxleftright;
        int curvedpath = root.val + lpath + rpath;
        
        int curmax = Math.max(root.val,Math.max(linearmax,curvedpath));
        max = Math.max(curmax,max);
        
        
        return Math.max(linearmax,root.val); //return linear path
        
    }
}
