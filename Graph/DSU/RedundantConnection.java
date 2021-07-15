package Graph.DSU;

public class RedundantConnection {
    static int[] par;
    static int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        par  = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
            rank[i] = 1;
        }
        
        for(int[] edge : edges){
            boolean ans = union(edge[0]-1,edge[1]-1);
            if(ans){
                return edge;
            }
        }
        //yha pe kbhi phochenge ni
        return new int[0];
        
    }
    
     public static int find(int x){
        if(par[x] == x){
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }
    
    public static boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly){
             if(rank[lx] > rank[ly]){
                par[ly] = lx;
            }
            else if(rank[ly] > rank[lx]){
                par[lx] = ly;
            }
            else{
                par[lx] = ly;
                rank[ly]++;
            }
            return false;
        }
        else{
            return true;
        }
    }
}
