package Graph.DSU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumOfIslandsDSU {
    class Point {
             int x;
             int y;
             Point() { x = 0; y = 0; }
             Point(int a, int b) { x = a; y = b; }
         }
    static int[] par;
    static int[] rank;
    static int count;
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        ArrayList<Integer> ans = new ArrayList<>();

        if(operators == null || operators.length == 0){
            return ans;
        }
        par = new int[n * m];
        rank = new int[n * m];
        count = 0;
        Arrays.fill(par,-1);
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        for(int i = 0; i < operators.length; i++){
            int r = operators[i].x;
            int c = operators[i].y;

            int cellno = r * m + c;
// is case m merging and all ho rkhi h to isme count m frk ni pdega kyuki ye cellno ko leader assigned h
            
            if(par[cellno] != -1){
                ans.add(count);
                continue;
            }
            //first time m khud hi leader bnega
            par[cellno] = cellno;
            rank[cellno] = 1;
            // nya set jo bna h uss ka count
            count++;
            // ab check krenge adjacent kisi set k sath merge ho skta h yani
            for(int j = 0; j < dirs.length; j++){
                int rdash = r + dirs[j][0];
                int cdash = c + dirs[j][1];

                int celldash = rdash * m + cdash;
                if(rdash < 0  || cdash < 0 || rdash >= n || cdash >= m|| par[celldash] == -1){
                    continue;
                }
                union(cellno,celldash);
            }
            ans.add(count);
        }
        return ans;

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
            count--;
            // ye tree ki height ko sudhar krne k liye hmesha jiski rank bdi h usme join hoga
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
