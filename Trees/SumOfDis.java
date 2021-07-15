package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class SumOfDis {
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
    HashMap<Integer,ArrayList<Integer>> map;
    int[] count;
    int[] ans;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            map.get(u).add(v);
            map.get(v).add(u);
        }
        
        count = new int[n];
        ans = new int[n];
        int src =0;
        
//fill the count array int which  count[0] contains total nodes present in subtree containing 0 as root
        traversal(src,new boolean[n]); 
       
  /* in this function we will count the sum distance of keeping 0 as root node ans[0] will get filled
  after this func, adding levels of the tree*/      
        
        levelOrder(src,new boolean[n]);
/* now if we know the parent ans, we can find the its child ans i.e  if ans[0] = 8,
then when we compute about its nbr, uss nbr k subtree m hr edge  1 se km ho jaegi, to hme total ans m use
un km hui edges ko htana hoga, kyuki jb 0 src tha to 0,2 ka distance 1 tha, but ab hm 2 ko root manre h to 
2 se 3 ka distance 1-1 = 0 hoga ab jo bchi edges unko + krna hoga, 
          1
        /  \
      2     3
    /      / \
   4      5   6   ab 1 se jo ans aaya h vo h 8, jb 3 ka ans aaega to 3 ko root bnaenge, to isme
   1 k ans m 1 se 3 ka dis 1 add hua tha, pr 3 k ans 3-3 ka dis 1-1 0 hoga, aise hi 3 k subtree ki hr edge m
   se 1 minus hoga, ans - count[3]
   now, 1 se 2 ka distance 1 tha, but 3 se uska distance 3 hoga, to vo nodes jo 3 k subtree m ni h,
   usme sbme +1 krna hoga
   to final ans  = ans[1] - count[3] + (N - count[3])

*/
        
        answercalc(src,new boolean[n],n);
        
        
        return ans;
        
    }
    public  void answercalc(int src, boolean[] vis, int N){
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        vis[src] = true;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0 ){
                int parent = q.remove();
                for(int child : map.get(parent)){
                    if(vis[child] == false){
                    ans[child] = ans[parent] - count[child] + (N - count[child]);
                        vis[child] = true;
                        q.add(child);
                    }
                }
            }
        }
    }
    
    public  void levelOrder(int src,boolean[] vis){
        vis[src] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int level = 0;
        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){
                int rem = q.remove();
                ans[src] += level;
                
                for(int nbrs : map.get(rem)){
                    if(vis[nbrs] == false){
                        vis[nbrs] = true;
                        q.add(nbrs);
                    }
                }
            }
                level++;
            
        }
        // System.out.println(ans[src]);
    }
    public  int traversal(int src, boolean[] vis){
        vis[src] = true;
        
        for(int nbrs : map.get(src)){
            if(vis[nbrs] == false){
                // System.out.println(nbrs);
                count[src] += traversal(nbrs,vis); 
                
            }
        }
        count[src] += 1;
        return count[src];
    }
}
