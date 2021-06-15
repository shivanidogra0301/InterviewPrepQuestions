package Trees.Traversals_iterative;

import java.util.ArrayList;

public class BoundaryTraversals {
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
    ArrayList <Integer> printBoundary(Node node)
	{
	    
	    ArrayList <Integer> list = new ArrayList<>(); 
	    if(node == null){
	        return list;
	    }
	    list.add(node.data);
	    printleftboundary(node.left,list);
	    printleafNode(node,list);
	    printrightboundary(node.right,list);
	    return list;
	}
	
	public static void printleftboundary(Node node,ArrayList <Integer> list){
	    if(node == null){
	        return;
	    }
	    if(node.left != null){
	        list.add(node.data);
	        printleftboundary(node.left,list);
	    }
	    else if(node.right != null){
	        list.add(node.data);
	        printleftboundary(node.right,list);   
	    }
	    else{
	        return;
	    }
	    
	}
	public static void printleafNode(Node node,ArrayList <Integer> list){
	    if(node == null){
	        return;
	    }
	    if(node.left == null && node.right == null){
	        list.add(node.data);
	    }
	    printleafNode(node.left,list);
	    printleafNode(node.right,list);
	    
	}
	
	public static void printrightboundary(Node node,ArrayList <Integer> list){
	    if(node == null){
	        return;
	    }
	    if(node.right != null){
	        
	        printrightboundary(node.right,list);
	        list.add(node.data);
	    }
	    else if(node.left != null){
	        
	        printrightboundary(node.left,list); 
	        list.add(node.data);
	    }
	    else{
	        return;
	    }
	    
	}
}
