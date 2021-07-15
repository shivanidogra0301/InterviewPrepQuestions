package Trees.Construction;

public class BSTfromPost {
    static class Node{
            int data;
            Node left,right;
            Node(int d)
            {
                data=d;
                left=right=null;
            }
        }
    public static Node constructTree(int post[],int n)
    {   //given post order, root node is last element. start constructing
        idx = post.length-1;
        return construct(post,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    static int idx; //for iterating in post order
    public static Node construct(int[] post, int min, int max){
        if(idx == -1){
            return null;
        }
        
        if(post[idx] >= min && post[idx] <= max){
            /*pre order m tree bnega  pr right ki call phle lgegi kyuki LRN agr last element  root h to
             uska left element ya to right hoga, agr right ni hua(range m ni hua to) to mtlb right subtree 
             exist ni krta null return kr denge uske bad usko left m check krenge hr level pe range
          call k time de denge to tree extra value bas construct hoga mtlb agr 40 ek position
          pe satisfy ho ra h to uss post order k liye vhi uski correct position h*/
            Node node = new Node(post[idx]);
            int key = post[idx];
            idx--;
            node.right = construct(post,key + 1,max);
            node.left = construct(post,min,key-1);
            
            return node;
        }
        return null;
        
    }

    /*another aproach is to first make next smalllest element on left. then iterate from last element in array
 and find the index of nsl 0 to nsl idx is left subtree and nslidx+1 t0 last is right subtree;
    */
}
