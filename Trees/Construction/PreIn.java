package Trees.Construction;

import java.util.HashMap;

public class PreIn {
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //here  we pass pointers of preorder and inorder array (range jahan se tree banana h)       
        map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i],i);
        }
        return construct(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }
    
    public TreeNode construct(int[] pre, int ps, int pe, int[] in, int is, int ie){
        if( is > ie){
            return null;
        }
        
        /*find the idx of preorder[ps] first case m ps = 0 hota h to phle root node ka
        index inorder m dhunda and inorder se uske left subtree and right subtree ki values nikal li. kyuki hr level pe ek node bnti jaegi to ps us node to point krega jisko abhi root bnana h uss subtree ka*/
        
        TreeNode root = new TreeNode(pre[ps]);
        int idx = map.get(pre[ps]);
        
        int count = idx - is; //in[idx]  is excluded root node ko htake total nodes
        
        /* ps ko node bna dia, to ab left subtree m next node ps+1 hi hoga so ps = ps+1,
        pe = ps+count (ps+1 m count add krdo or count se idx nikalne k liye -1)i.e 
        ps+1+count -1 = ps+count, 'is' same rhega ie idx-1 ho jaega */
        /* right subtree m ps = left k pe+1 se chlega and pe same, is b same */
        root.left = construct(pre,ps+1,ps+count,in,is,idx-1);
        root.right = construct(pre,ps+count+1,pe,in,idx+1,ie);
        return root;
    }
}
