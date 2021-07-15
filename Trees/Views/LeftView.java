package Trees.Views;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftView {
    static class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> list = new ArrayList<>();
      Queue<Node> q = new LinkedList<>();
      if(root == null){
          return list;
      }
      q.add(root);
      
      while(q.size() > 0){
          int size = q.size();
          for(int i = 0; i < size; i++){
              Node parent = q.remove();
              if(i == 0){
                  list.add(parent.data);
              }
              if(parent.left != null){
                  q.add(parent.left);
              }
              if(parent.right != null){
                  q.add(parent.right);
              }
          }
      }
      return list;
      
    }
}
