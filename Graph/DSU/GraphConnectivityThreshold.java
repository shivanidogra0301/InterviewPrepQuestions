package Graph.DSU;
import java.util.*;
/*
    isme hme, 1 to n vtx given h, or kuch queries hme btana h ki given query k liye path exist krta h ya ni
    do vts k bich edge tbhi hogi if dono ko common divisor given threshold se zyada hoga
    to hm phle 1 to n k sare pairs m se valid pairs ka union kr denge then find function
    se pta kr lenge ki path present h ya ni

*/
public class GraphConnectivityThreshold {

    int[] par;
    int[] rank;
    public List<Boolean> areConnected(int n, int th, int[][] queries) {
        par = new int[n+1];
        rank = new int[n+1];
        
        for(int i = 1; i <= n; i++){
            par[i] = i;
            rank[i] = 1;
        }
        // number th se bda hona chaiye so i = th+1 and use sare multiples jo n se chhote h vo dal dege
         for (int i = th+1; i <= n; i++) {
            int m = 1;  
            while (i*m <= n) {
                union(i, i*m);  
                m++; 
            }
        }
        
       
        List<Boolean> ans = new ArrayList<>();
        
        for(int i =0; i < queries.length; i++){
            int x = queries[i][0];
            int y = queries[i][1];
            if(find(x) == find(y)){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
            
        }
        return ans;
        
        
    }
    
    public  int find(int x){
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
