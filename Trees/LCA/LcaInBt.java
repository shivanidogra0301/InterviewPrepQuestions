package Trees.LCA;

public class LcaInBt {
    static class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    Node lca(Node root, int n1,int n2)
	{
	    if(root == null){
	        return null;
	    }
	    
	    if(root.data == n1 || root.data == n2){ 
    /* agr dono m se ek k b equal ho to aage calls ni lgani, kyuki dusra agr niche exist b kia to 
    uska ans yehi node hogi ye lca ki trah act krega
*/
	        return root;
	    }
        //ab agr khud ni h, to subtree se puchenge ki exist krta h ya ni
	    Node left = lca(root.left,n1,n2);
	    Node right = lca(root.right,n1,n2);
	    
        // null means does not exist in this subtree
	    if(left == null && right == null){ 
	        return null;
	    }
/*left null ni h, mtlb left m exist krta h, to left bhejdo as a boolean value to tell 
parent ki is subtree m  ek node exist krta h*/
	    else if(left != null && right == null){
	        return left;
	    }
        //same as left
	    else if(left == null && right != null){
	        return right;
	    }
        //this means one node exist in left and one in right, so root is the ans
	    else{
	        return root;
	    }
	}
}
