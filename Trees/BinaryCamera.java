package Trees;

public class BinaryCamera {
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
    int camera;
    public int minCameraCover(TreeNode root) {
        camera = 0;
        int temp = countcamera(root);
        if(temp == 0){
            return camera+1; //agr recursion se root node ka status ye aaya ki vo apne parent se observe hone ki khra jo ki exist ni krta
        }
        return camera;
    }
    
    public int countcamera(TreeNode root){
        if(root == null){ //dummy leaf node
            return 2;
        }
        int lnode = countcamera(root.left);
        int rnode = countcamera(root.right);
        if(lnode == 0 || rnode == 0){ //leaf node present to camera must lgega
            camera++;
            return 1;
        }
        if(lnode == 1 || rnode == 1){ //children m kisi ek m camera lga hua h and dusri node m ya to camera h ya observed h to no need for camera returned observed
            return 2;
        }
        return 0; // dono children m 2 h yani dono observed h to ye curnode ab dummy leaf node ki trah kaam kregi
    }
}
