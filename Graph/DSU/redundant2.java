package Graph.DSU;

import java.util.Arrays;

public class redundant2 {
/* iss ques m teen cases bnte h, first ki graph m ek cycle present h, or sbki indegree 1 h. Is type k graph
m hmare ans last node jiski vjah se cycle bni h vhi hoga to vo hm union find krete hue nikal lenge
seconde case jb graph m kisi node ki indegree 2 h, isme do cases bn skte h ki cycle present hogi ya ni
agr indegree 2 h, hm dono edges ko store krlenge jiski vjah se indegree 2 h. agr latest node jiski vjh se
indegree 2 hui h usko blacklist krke bhi cycle present h, to bl2 hmara ans hoga(kyuki usne hi pkka cycle bnayi hogi)
. pr agr bl1 usko htane pr cycle present ni h mtlb do case ho skte ki bl1 ki vjah se cycle bni is case m ans bl1 
hoga ya fr graph m cycle h hi ni is case m b bl1 ans hoga , (bl2 b ho skta tha but hme 
latest bhejna tha to bl1)*/
    
    static int[] par;
    static int[] rank;
    public int[] findRedundantDirectedConnection(int[][] edges) {
        par = new int[edges.length+1];
        rank = new int[edges.length+1];
/*indeg contains the row index of edge from edges array jiski vjah se indegree 1 hui h
kyuki hme u or v dono bhejne h array ki form m to hm uss row ka index rkh lenge*/
        int[] indeg = new int[edges.length+1];
/* latest  edge ka  row index  jiski vjah se indegree 2 hui h*/
        int bl1 = -1;
/* purani edge ka  row index jiski vjah vjah se indegree 1 hui thi*/
        
        int bl2 = -1;
/* basically hm vo dono edge ko store krre h jiski vjah se use vtx ki indegree 2 hui h
jisme dono m se possible ans ho skte h*/
        for(int i = 1; i < edges.length+1; i++){
            par[i] = i;
            rank[i]=1;
        }
        
        Arrays.fill(indeg,-1);
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            if(indeg[v] == -1){
                indeg[v] = i;
            }
            else{
                bl1 = i;
                bl2 = indeg[v];
            }
            
        }
        // System.out.println(bl1+" "+bl2);
        
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(i == bl1){
                continue;
            }
            
            boolean cyclepresent = union(u,v);
            if(cyclepresent){
                //case 1 cycle present and  no one has indegree 1
                if(bl1 == -1){
                    return edges[i];
                }
                //case 2 , cycle present even after removing bl1
                else{
                    return edges[bl2];
                }
            }
        }
        //cycle not present 2 cases bl1 ki vjah se cycle thi, ya graph m cycle ni thi
        return edges[bl1];
    }
    
    public int find(int x){
        if(par[x] == x){
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }
    
    public boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly){
            if(rank[lx] > rank[ly]){
                par[ly] = lx;
            }
            else if(rank[lx] < rank[ly]){
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
