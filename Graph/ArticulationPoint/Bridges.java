package Graph.ArticulationPoint;

import java.util.ArrayList;
/* isme hme edgs btani h jiske htane se graph unconnected hoga, to equal vali condition hta denge to
isse jb node articulation point h to ek k liye contidition true hogi or vo ans m dl jaega*/
public class Bridges {
    int[] par;
    int[] disc;
    int[] low;
    boolean[] vis;
    int time;
    ArrayList<ArrayList<Integer>> ans;
    ArrayList<ArrayList<Integer>> graph;
    public ArrayList<ArrayList<Integer>> criticalConnections(int n, ArrayList<ArrayList<Integer>> connections) {
        graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0 ; i < connections.size(); i++){
            int u = connections.get(i).get(0);
            int v= connections.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);                   
        }
        par = new int[n];
        disc = new int[n];
        low = new int[n];
        vis = new boolean[n];
        ans = new ArrayList<>();
        time = 0;
        articulationpoint(0);
        return ans;
        
    }
    public  void articulationpoint(int u){
        low[u] = disc[u] = time;
        time++;
        vis[u] =true;
        for(int v : graph.get(u)){
            if(par[u] == v){
                continue;
            }
            else if(vis[v] == true){
                low[u] = Math.min(low[u],disc[v]);
            }
            else{
                par[v] = u;
                articulationpoint(v);

                if(low[v] > disc[u]){
                    ArrayList<Integer> edge = new ArrayList<>();
                    edge.add(u);
                    edge.add(v);
                    ans.add(edge);
                }
                low[u] = Math.min(low[u],low[v]);
            }
        }
    }
}
