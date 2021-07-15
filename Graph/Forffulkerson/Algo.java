package Graph.Forffulkerson;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Algo {
    int solve(int N, int M, ArrayList<ArrayList<Integer>> Edges) 
    { 
        int[][] graph = new int[N][N];
        for(int i = 0; i < Edges.size(); i++){
           int u = Edges.get(i).get(0)-1;
           int v = Edges.get(i).get(1)-1;
           int wt = Edges.get(i).get(2);
           
           graph[u][v] += wt;
          graph[v][u] += wt;
           
        }
        int[] parent = new int[N];
        int src = 0;
        int sink = N-1;
        int ans = 0;
        while(bfs(src,sink,graph,parent)){
            int min = Integer.MAX_VALUE;
            for(int i = sink; i != src; i = parent[i]){
                int u = parent[i];
                int v = i;
                
                min = Math.min(min,graph[u][v]);
                
            }
            ans+= min;
            for(int i = sink; i != src; i = parent[i]){
                int u = parent[i];
                int v = i;
                
                graph[u][v] -= min;
                graph[v][u] += min;
            }
        }
        
        return ans;
        
    }
    
    public boolean bfs(int src,int sink,int[][] graph,int[] path){
        boolean[] vis = new boolean[path.length];
        vis[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        
        while(q.size() > 0){
            int rem = q.remove();
            
            for(int i = 0; i < graph[0].length; i++){
                if(vis[i] == false && graph[rem][i]!= 0){
                    q.add(i);
                    vis[i] = true;
                    path[i] = rem;
                }
            }
        }
        return vis[sink];
    }
}
