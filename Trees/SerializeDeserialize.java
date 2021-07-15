package Trees;

public class SerializeDeserialize {
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
    public String serialize(TreeNode root) {
        String ans = helper(root);
        // System.out.println(ans);
        return ans;
    }
    public String helper(TreeNode root){
        if(root == null){
            return "#_";
        }
        String str = root.val +"_";
        str+= helper(root.left);
        str+= helper(root.right);
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split("_");
        idx = 0;
        return helperdes(str);
    }
    static int idx;
    public TreeNode helperdes(String[] str){
        if(str[idx].equals("#")){
            idx++;
            return null;
        }
        // System.out.println(str[idx]);
        
        TreeNode node = new TreeNode(Integer.parseInt(str[idx]));
        idx++;
        node.left = helperdes(str);
        node.right = helperdes(str);
        return node;
    }
}
