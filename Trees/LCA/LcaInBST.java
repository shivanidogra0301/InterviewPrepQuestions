package Trees.LCA;

public class LcaInBST {
    static public class TreeNode {
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if(root.val > p.val && root.val > q.val){ 
                // if root ki value dono se bdi h to dono element left m milenge
                root = root.left;
            }
            else if(root.val < p.val && root.val < q.val){
                // if root ki value dono se chhoti h to dono element right m milenge
                root = root.right;
            }
            else{
//this means dono element ek side ni h, koi right koi left m h, yani yha se tree split hora h so this is the answer
                return root;
            }
        }
        return null;
    }
}
