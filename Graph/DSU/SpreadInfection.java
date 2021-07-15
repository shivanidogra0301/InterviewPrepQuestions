package Graph.DSU;

import java.util.HashMap;
/* is ques m hme initial infected nodes given h, hme btana inn m konsi ek node hta skte h jisse hm zyada nodes
ko infect hone se bacha skte h, agr component m ek b node infected vo sari node ko 0 time m infect kr degi
to hme vo connected component jisme 1 se zyada infected nodes h unko nhi ginna h, fr jin compoenent
m infected node 1 h, and uss component ka size jisme sbse zyada h vhi hmara ans hoga*/
public class SpreadInfection {
    static int[] par;
    static int[] size;
    public int minMalwareSpread(int[][] graph, int[] initial) {
        par = new int[graph.length];
        size = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            par[i] = i;
            size[i] = 1;
        }
        //to make graph
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[0].length; j++){
                if(i == j){
                    continue;
                }
                if(graph[i][j] == 1){
                    union(i,j);
                }
            }
        }
        //map infected node k parent to number of infected nodes present ni that graph
        HashMap<Integer,Integer> CountInfected = new HashMap<>();
        
        for(int i = 0; i < initial.length; i++){
            int parent = find(initial[i]);
            CountInfected.put(parent,CountInfected.getOrDefault(parent,0)+1);
        }
        int ans = -1;
        int count = -1;
        
        for(int i = 0; i < initial.length; i++){
            int parent = find(initial[i]);
            int sz = size[parent];
            
            if(CountInfected.get(parent) >= 2){
                sz = 0;
            }
            //agr bchne vali node zyada h to update count, and ans
            if(sz > count){
                count = sz;
                ans = initial[i];
            }
            else if(sz == count){
                // if two component have same bchne vali nodes to jo index wise phle aaya h vo and hoga
                ans = Math.min(initial[i],ans);
            }
        }
        return ans;
    }
    
    
    
    public int find(int x){
        if(par[x] == x){
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }
    
    public void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly){
            if(size[lx] > size[ly]){
                par[ly] = lx;
                size[lx]+= size[ly];
            }
            else if(size[lx] < size[ly]){
                par[lx] = ly;
                size[ly]+= size[lx];

            }
            
        }
        
    }

}
