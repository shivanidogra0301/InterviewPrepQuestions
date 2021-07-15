package Trees.Traversals_iterative;

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;

public class DiagonalTraversal {
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
    /* diagonals m jana h to phle right m jao or print krdo but hr time jb right jao ussphle uska left agr 
    exist krta h to usko queue m daldo kyyuki ek case ho skta h jisme uska(left node) right exist ni krta but uske(parent node) k  right
     ka left exist krta h to to vo next diagonal m print hona chaiye isliye sb left child ko queue
    , dalenge*/
    public ArrayList<Integer> diagonal(Node root)
      {
        ArrayList<Integer> list = new ArrayList<>();
          Queue<Node> q = new LinkedList<>();
          
          q.add(root);
          while(q.size() > 0){
              Node rem = q.remove();
              while(rem != null){
                  if(rem.left != null){
                      q.add(rem.left);
                  }
                  list.add(rem.data);
                  rem = rem.right;
              }
          }
          return list;
      }
}
