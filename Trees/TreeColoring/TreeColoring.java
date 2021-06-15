package Trees.TreeColoring;

public class TreeColoring {
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
    static int lc ;
    static int rc;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
        lc  = 0;
        rc = 0;
        CountNodes( root, x); 
        int pc = n - lc - rc - 1;
        int bestchoice = Math.max(lc,Math.max(rc,pc));
        if(bestchoice > n/2){
            return true;
        }
        return false;
    }
    
    public static int CountNodes(TreeNode root,int x){
        if(root == null){
            return 0;
        }
        int leftcount = CountNodes(root.left,x);
        int rightcount = CountNodes(root.right,x);
        if(x == root.val){ //condition runs only one time and post order so we get the left and right count of x node so no need to run recursion further
            lc = leftcount;
            rc = rightcount;
            return 0;
        }
        return leftcount + rightcount + 1;
    }
}
