package Trees.FlatTree;

public class SortedListToBST {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
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
    ListNode temp;
    public TreeNode sortedListToBST(ListNode head) {
        temp = head;
        int count = 0;
        ListNode check = head;
        while(check != null){
            count++;
            check = check.next;
        }
        return construct(count);
        
    }
    public  TreeNode construct(int n){
        if(n == 0){
            return null;
        }
        TreeNode leftchild = construct(n/2); //make structure then add node
        
        TreeNode root = new TreeNode(temp.val);
        root.left = leftchild;
        temp = temp.next;
        root.right = construct(n-n/2-1);
        return root;
    }
}
