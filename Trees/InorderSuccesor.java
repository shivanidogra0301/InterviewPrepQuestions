package Trees;

public class InorderSuccesor {
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode ans = null;
        while(root!= null){
            if(root.val == p.val){ 
                //this condition same like finding a node

                TreeNode rightp1 = null;
                if(root.right != null){ 
                    /*root k right ka leftmost node is inorder successor hoga
                     agr right exist ni krta then parent hoga ans jo phle se hi ans m store hoga */
                    rightp1 = root.right;

                    while(rightp1.left != null){
                        rightp1 = rightp1.left;
                    }
                    ans =  rightp1;
                }
                break;
                
            }
            else if(root.val < p.val){
                root = root.right;
            }
            else{
                ans = root;
                root = root.left; //if going left then root could possibly a ans so store it
            }
        }
        return ans;
    }
}
