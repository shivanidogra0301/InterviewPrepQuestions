package Trees.Construction;

public class BSTfromPre {
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
    public static TreeNode bstFromPreorder(int[] pre) {
        idx = 0;
        return construct(pre,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    static int idx;
    public static TreeNode construct(int[] pre, int min, int max){
        if(idx == pre.length){
            return null;
        }
        
        if(pre[idx] >= min && pre[idx] <= max){
            
            TreeNode node = new TreeNode(pre[idx]);
            int key = pre[idx];
            idx++;
            node.left = construct(pre,min,key-1); //pre m phle left ki call lgegi
            
            node.right = construct(pre,key + 1,max);
            
            return node;
        }
        return null;
        
    }
}
