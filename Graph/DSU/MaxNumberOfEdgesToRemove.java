package Graph.DSU;

import java.util.Arrays;
/*
 hm hr edge ki type given h type 1 means alex can travel, type 2 means john can travel, type 3 means both can
 travel \. So hme max edges delete krni h taki dono poore graph m travel kr ske. which mean min edges
 nikalni ki dono travel kr ske and usko total edges m se se minus kr dena h.
 Now for minimum edges, hme type 3 vali edges se start krna chaiye tbhi min ans aaega, or union krte
 jaenge ki cycle ni bni to count++, do array rkhenge separate for john and alex kyuki dono
 ko trvael krvana h, agr t=3 h, to dono m union hoga pr count ek hi hoga kyuki same
 edge hi use hui h, ohterwise dono ka count alg alg lenge.
 last m total - count is ans

 another edge case ki given graph m jo edges h usko use krke b hm dono ko poore graph m travel ni krva
 paye, means jinke parent array m ek se zyada component hue, to mtlb hmara ans exist ni krta in that
 case return -1;

*/
public class MaxNumberOfEdgesToRemove {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        Arrays.sort(edges,(a,b) ->  Integer.compare(b[0],a[0]) );
         int[]para = new int[n];
         int[] parb= new int[n];
         int[] ranka= new int[n];
         int[] rankb= new int[n];
        for(int i = 0; i < n; i++){
            para[i] = i;
            parb[i] = i;
            ranka[i] =1;
            rankb[i] =1 ;
        }
        int count= 0;
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][1]-1;
            int v = edges[i][2]-1;
            boolean ans = false;
            if(edges[i][0] == 3){
                ans = union(u,v,para,ranka);
                boolean ans2 = union(u,v,parb,rankb);
                
            }
            else if(edges[i][0] == 2){
                ans=union(u,v,parb,rankb);
                
            }
            else if(edges[i][0] == 1){
                ans =union(u,v,para,ranka);
                
            }
            if(ans){
                count++;
            }
            
            // System.out.println("u "+ u + "v "+ v + "count "+count);
        }
        int c = 0;
        
        for(int i = 0; i < n; i++){
            if(para[i] == i){
                c++;
            }
            if(parb[i] == i){
                c++;
            }
        }
        
        if(c > 2){
            return -1;
        }
        
        
        return edges.length - count;
        
    }
    
    public int find(int x, int[] par){
        if(par[x] == x){
            return x;
        }
        int temp = find(par[x],par);
        par[x] = temp;
        return temp;
        
    }
    public boolean union(int x, int y, int[] par, int[] rank){
        int lx = find(x,par);
        int ly = find(y,par);
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                par[ly] = lx;
            }
            else if(rank[ly] > rank[lx]){
                par[lx] = ly;
            }
            else{
                par[lx] = ly;
                rank[lx]++;
            }
            return true;
        }
        else{
            return false;
        }
    }
}
