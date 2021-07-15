package Graph.Euler;

import java.util.ArrayList;
/*
    undirected graph m, euler path m agr srf do nodes ki degree odd h, baki ki even h to euler path exist
    
    euler cycle, agr hr node ki degree even hui to euler cycle kyuki hr node m aane or usse bahar jane
    ka rsta present h

*/
public class UndirEulerPath {

    static int eulerPath(int N, int graph[][]){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i =0 ; i < N; i++){
            list.add(new ArrayList<>());
        }
        for(int i =0 ; i < graph.length; i++){
            for(int j = 0; j < graph.length; j++){
                if(graph[i][j] == 1){
                    list.get(i).add(j);
                }
            }
        }
        int count = 0;
        for(int i = 0; i < N; i++){
            if(list.get(i).size()%2!= 0){
                count++;
            }
        }
        if(count <= 2){
            return 1;
        }
        return 0;
    }

    public boolean isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] deg = new int[V];
        
        
        for(int i =0; i < V; i++){
            for(int nbrs : adj.get(i)){
                deg[i]++;
                
            }
        }
        for(int i =0; i < V; i++){
            if(deg[i]%2 != 0){
                return false;
            }
        }
        return true;
        
    }
}
