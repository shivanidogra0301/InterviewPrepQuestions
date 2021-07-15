package Trees.Construction;

import java.util.HashMap;

public class PrePost {
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
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(pre.length == 1){
            return new TreeNode(pre[0]);
        }
        map = new HashMap<>();
        for(int i = 0; i < post.length; i++){
            map.put(post[i],i);
        }
        
        return construction(pre,0,pre.length-1,post,0,post.length-1);
        
        
    }
    
    public TreeNode construction(int[] pre,int pres,int pree,int[] post,int posts, int poste){
        if(pres > pree || posts > poste){
            return null;
        }
    // we know that first node in preorder is node
        
        TreeNode node = new TreeNode(pre[pres]);
        if(pres == pree || posts == poste){
            return node;
        }
//now check next node of pre (left) in post order,idx ,in post order 0 to idx will give postorder of left subtree, recursively do this step.
        int idx = map.get(pre[pres+1]);
        int count = idx - posts + 1;
        node.left = construction(pre,pres+1,pres+count,post,posts,idx);
        node.right = construction(pre,pres+count+1,pree,post,idx+1,poste-1);
        
        return node;
    }
}
