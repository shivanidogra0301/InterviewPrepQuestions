package Trees.Traversals_iterative;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;
public class TopView {
    public class Node {
        int data;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.data = val; }
        Node(int val, Node left, Node right) {
            this.data = val;
            this.left = left;
            this.right = right;
        }
    }
    static class Pair{
        Node node;
        int level;
        Pair(Node node, int level){
            this.node = node;
            this.level = level;
        }
    }
//Function to return a list of nodes visible from the top view 
//from left to right in Binary Tree.
static ArrayList<Integer> topView(Node root)
{
    ArrayList<Integer> ans = new ArrayList<>();
    Queue<Pair> q = new LinkedList<>();
    HashMap<Integer,Integer> map = new HashMap<>();
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    q.add(new Pair(root,0));
    
    while(q.size() > 0){
        int size = q.size();
        for(int i = 0; i < size; i++){
            Pair rem = q.remove();
            min = Math.min(rem.level,min);
            max = Math.max(rem.level,max);
            if(!map.containsKey(rem.level)){
                map.put(rem.level,rem.node.data);
            }
            if(rem.node.left != null){
                q.add(new Pair(rem.node.left,rem.level-1));
            }
            if(rem.node.right != null){
                q.add(new Pair(rem.node.right,rem.level+1));
            }
        }
    }
    for(int i = min; i <= max; i++){
        ans.add(map.get(i));
    }
    return ans;
    
    
}
}
