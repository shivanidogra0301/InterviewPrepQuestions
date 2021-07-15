package Graph;
import java.util.*;
/* is ques m hme safe nodes ki list bhejni h, jisme cycle present ni h, or na hi self loop
cannotuse topological sort, kyuki vo self loop ko handle ni kr skta. so we use diffrent strategy
h, jate hue hr vts ko vis mark krenge,
vis[src] = 0  unvisited node
vis[src] = -1 currently sarching, agr ek node ka ans abhi calculate ho ra, to uske nbrs pe janeg
or path aayi sari nodes ko -1 dalte jaenge aise krte hue agr koi aisi node mili jiski state
abhi -1 h, mtlb vo iss path m phle aa chuki h that means cycle.  to aage check krne ki jrurt ni
simple uss node ko unsafe kh denge
vs[src] = 1 safe

*/
public class EventualSafeState {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int[] vis = new int[graph.length];
    
        for(int i = 0; i < graph.length; i++)
            if(dfs(graph, i, vis) == 1)
                res.add(i);
    
        return res;
    }
    
    private int dfs(int[][] adj, int src, int[] vis){
        if(vis[src] != 0) return vis[src];//0 represents unvisited node
    
        vis[src] = -1;//-1 represents current search
    
        for(int neighbor : adj[src])
            if(dfs(adj, neighbor, vis) == -1) 
                return -1;//unsafe node return immediately 
        //this area mean no nbr of the src is unsafe which means src is also safe, so change it to safe state
        vis[src] = 1;
        return vis[src] ;//1 represents safe node
        }
}
