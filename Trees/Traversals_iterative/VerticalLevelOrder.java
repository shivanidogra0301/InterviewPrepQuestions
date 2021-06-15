package Trees.Traversals_iterative;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;

public class VerticalLevelOrder {
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
    class Pair{
        TreeNode node;
        int level;
        Pair(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    /*here  hm nodes ko vl k basis pe sort krenge using min max in hashmap,if nodes have same vertical 
    level(nodes present in arraylists) than sort acc to horizontal level but if some nodes have same horizontal
    vertical level then we need to sort acc to the values present in node(inc order) so in hashmap 
    arraylist containing hl if level are not same then they are sorted on basis of hl jo top pe h vo
    phle aaega but agr vo b same h then hm values k basis pe krege  */
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer,ArrayList<Pair>> map = new HashMap<>(); //isme alist m horizontal level dlenge
        int hl = 0;
        Queue<Pair> q = new LinkedList<>(); 
        q.add(new Pair(root,0)); //queue m vertical level dlenge
        int min = Integer.MAX_VALUE; // to run loop in order in hashMap (min/max vertical level)
        int max = Integer.MIN_VALUE;
        while(q.size() > 0){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Pair rem = q.remove();
                min = Math.min(min,rem.level);
                max = Math.max(max,rem.level);
                if(!map.containsKey(rem.level)){
                    ArrayList<Pair> l = new ArrayList<>();
                    l.add(new Pair(rem.node,hl));
                    map.put(rem.level,l);
                }
                else{
                    map.get(rem.level).add(new Pair(rem.node,hl));
                }
                if(rem.node.left != null){
                    q.add(new Pair(rem.node.left,rem.level-1)); //left node vertical level is current level - 1
                }
                if(rem.node.right != null){
                    q.add(new Pair(rem.node.right,rem.level+1));
                }
            }
            hl++;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = min; i <= max; i++){
            ArrayList<Pair> list = map.get(i);
            Collections.sort(list,(a,b) -> {
                if(a.level != b.level) return a.level - b.level;
                else return a.node.val - b.node.val;
            });
            
            List<Integer> temp = new ArrayList<>();
            for(Pair p : map.get(i)){
                temp.add(p.node.val);
            }
            ans.add(temp);
        }
        return ans;
        
        
    }
}
