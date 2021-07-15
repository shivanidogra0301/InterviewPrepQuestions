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
    /* 0 - means m leaf node hu, ya dummy leaf node, to m khud camera ni lgauga, parent se manguga
     1 - means mne khud pe camera lga lia h'
     2 - means m observed hu
    */
    public int countcamera(TreeNode root){
        if(root == null){ 
    //null node mtlb uspe na hi camera h, na usko camera chaiye which is like observed node
                return 2;
        }
        int lnode = countcamera(root.left);
        int rnode = countcamera(root.right);
        if(lnode == 0 || rnode == 0){ 
            //left ya right m se kisi m b leaf node present to camera must lgega
            camera++;
            //camera lga lia to mera khud ka status 1 hogya
            return 1;
        }
        if(lnode == 1 || rnode == 1){ 
    /*children m kisi ek m camera lga hua h and dusri node confirm 0 nhi h agr hoti
        to first if m handle ho jati to mrko camera ki zrurt ni h return observed*/
            return 2;
        }
        return 0; 
        /* dono children m 2 h yani dono observed h to ye curnode ab dummy leaf node ki trah kaam kregi
        to optimal min ans k liye hm parent ko khenge camera lgani ki */
    }
}
