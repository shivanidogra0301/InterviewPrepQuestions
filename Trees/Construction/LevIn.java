package Trees.Construction;

import java.util.HashMap;

public class LevIn {
    static class Node{
        int data;
        Node left,right;
        Node(int d)
        {
            data=d;
            left=right=null;
        }
    }
    HashMap<Integer,Integer> map;
    Node buildTree(int inord[], int level[])
    {
        map = new HashMap<>();
        for(int i = 0; i< inord.length; i++){
            map.put(inord[i],i);
        }
    return construction(inord,0,inord.length - 1,level);
    }
    public  Node construction(int[] in,int is,int ie, int[] lev){
        if(is > ie || lev.length == 0){
            return null;
        }
        Node node = new Node(lev[0]);
        int idx = map.get(lev[0]);
        int[] nleft = new int[idx - is];
        int[] nright = new int[ie - idx];
        int li = 0;
        int ri = 0;
        for(int i = 0; i < lev.length; i++){
            int lidx = map.get(lev[i]);
            if(lidx < idx){
                nleft[li] = lev[i];
                li++;
            }
            else if(lidx > idx){
                nright[ri] = lev[i];
                ri++;
            }
        }
        node.left = construction(in,is,idx-1,nleft);
        node.right = construction(in,idx+1,ie,nright);
        
        return node;
        
    }
}
