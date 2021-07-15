package Graph;

import java.util.Arrays;

public class BellmanFord {
    /* hm hr edge ko v-1 bari visit krte h, where v is number of vertices. hm ye mante h ki ith iteration m
    i path length ka ans aa chuka hoga, to hm hr iteration m check krenge ki jese 0 1 m hr path length se ans
    dal denge jo min hoga vo store ho jaega
    works for both negative and positve wts 
    O(v^2)
*/

public int isNegativeWeightCycle(int n, int[][] edges)
{   int[] dist = new int[n];
    Arrays.fill(dist,Integer.MAX_VALUE);
    dist[0] = 0;
    for(int i = 0; i < n-1; i++){
        for(int j = 0; j < edges.length; j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            
            if(dist[u] == Integer.MAX_VALUE){
                continue;
            }
            
            if(dist[u] + wt < dist[v]){
                dist[v] = dist[u] + wt;
            }
        }
    }
    
    for(int j = 0; j < edges.length; j++){
            int u = edges[j][0];
            int v = edges[j][1];
            int wt = edges[j][2];
            
            if(dist[u] == Integer.MAX_VALUE){
                continue;
            }
            
            if(dist[u] + wt < dist[v]){
                return 1;
            }
        }
    return 0;
    
    
}
}
