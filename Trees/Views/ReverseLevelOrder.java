package Trees.Views;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//print levelorder in reverseorder

public class ReverseLevelOrder {
    static class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> list = new ArrayList<>();
         Queue<Node> q = new LinkedList<>();
      if(node == null){
          return list;
      }
      q.add(node);
      
      while(q.size() > 0){
          int size = q.size();
          for(int i = 0; i < size; i++){
              Node parent = q.remove();
                  list.add(parent.data);
              
              if(parent.right != null){
                  q.add(parent.right);
              }
              if(parent.left != null){
                  q.add(parent.left);
              }
              
          }
      }
      int i = 0;
      int j = list.size() -1;
      
      while(i < j){
          int temp = list.get(i);
          list.set(i,list.get(j));
          list.set(j,temp);
          i++;
          j--;
      }
      
      
      return list;
    }
}
