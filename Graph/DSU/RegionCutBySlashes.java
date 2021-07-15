package Graph.DSU;

public class RegionCutBySlashes {
    static int[] par;
    static int[] rank;
    static int count;
    public int regionsBySlashes(String[] grid) {
        // agr n slashes h to usko represent krne k liye n+1 point lgenge
        int n = grid.length;
        int dots = n+1;
        par = new int[dots * dots];
        rank = new int[dots * dots];
        for(int i = 0; i < dots * dots; i++){
            par[i] = i;
            rank[i] = 1;
        }
        //when no slash is present total region 1 hoga
        count = 1;
        
        for(int i = 0; i < dots; i++){
            for(int j = 0; j < dots; j++){
                if(i == 0 || j == 0 || i == dots-1 || j == dots-1){
                    int cellno = i * dots + j;
                    // ye condition isliye kyuki 0 ko leader bnaenge
                    if(cellno != 0){
                        union(0,cellno);
                    }
                }
            }
        }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid.length; j++){
                char ch = grid[i].charAt(j);
                if(ch == '/'){
                    int cellno1 = (i)*dots + j+1;
                    int cellno2 = (i+1)*dots + j;
                    
                    union(cellno1,cellno2);
                }
                else if(ch == '\\'){
                    int cellno1 = (i)*dots + j;
                    int cellno2 = (i+1)*dots + j+1;
                    
                    union(cellno1,cellno2);
                }
            }
        }
        return count;
        
        
    }
    
    
     public static int find(int x){
        if(par[x] == x){
            return x;
        }
        /* ek bar ans dhundlia i.e leader to jis b rste vha gye vha pe leader dal 
        denge taki next bar jane pr recursion utni bar call na ho*/
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }

    public static void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        if(lx != ly){
            // do set merge hoye to count-1 ho jaega
            // ye tree ki height ko sudhar krne k liye
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
        else{
            count++;
        }
    }
}
