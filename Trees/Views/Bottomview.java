package Trees.Views;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;

// map m hmesha put krte rhenge hr vlev ki node to jo last m aaegi vo update hoke map m aa jaegi
public class Bottomview {

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
    class Pair{
        Node node;
        int vlev;
        Pair(Node node, int vlev){
            this.node = node;
            this.vlev = vlev;
        }
        
    }
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList <Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                Pair rem = q.remove();
                Node rnode = rem.node;
                int lev = rem.vlev;
                min = Math.min(lev,min);
                max = Math.max(lev,max);
                
                map.put(rem.vlev,rnode.data);
                
                if(rnode.left != null){
                    q.add(new Pair(rnode.left,lev-1));
                }
                if(rnode.right != null){
                    q.add(new Pair(rnode.right,lev+1));
                }
            }
           
        }
         for(int i = min; i <= max; i++){
                list.add(map.get(i));
            }
            return list;
    }
}
