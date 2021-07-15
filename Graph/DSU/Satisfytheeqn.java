package Graph.DSU;

public class Satisfytheeqn {
      static int[] par;
    static int[] rank;
    public boolean equationsPossible(String[] equations) {
        par  = new int[26];
        rank = new int[26];
        for(int i = 0; i < 26; i++){
            par[i] = i;
            rank[i] = 1;
        }
        
        for(String eq : equations){
            char c1 = eq.charAt(0);
            char c2 = eq.charAt(3);
            if(eq.charAt(1) == '='){
                
            
                union(c1-'a',c2-'a');
                
            }
        }
        for(String eq : equations){
            char c1 = eq.charAt(0);
            char c2 = eq.charAt(3);
            if(eq.charAt(1) == '!'){
                if(find(c1-'a') == find(c2-'a')){
                    return false;
                }
                
            }
        }
        
        
        return true;
    }
    public static int find(int x){
        if(par[x] == x){
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }
    
    public static void union(int x, int y){
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
        }
    }
}
