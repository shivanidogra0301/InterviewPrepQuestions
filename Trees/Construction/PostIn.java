package Trees.Construction;

import java.util.HashMap;

public class PostIn {
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
    HashMap<Integer,Integer> map;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return construct(postorder,0,postorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode construct(int[] post, int ps, int pe, int[] in, int is, int ie){
        if( is > ie){
            return null;
        }
        
        
        
        TreeNode root = new TreeNode(post[pe]);
        int idx = map.get(post[pe]);
        
        int count = idx - is; //in[idx]  is excluded root node ko htake total nodes
        
        
        root.left = construct(post,ps,ps+count-1,in,is,idx-1);
        root.right = construct(post,ps+count,pe-1,in,idx+1,ie);
        return root;
    }
}
