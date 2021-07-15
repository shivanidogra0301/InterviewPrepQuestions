package Graph.StronglyConnected;

import java.util.ArrayList;
import java.util.Stack;

public class KosaRaju {
/* strongly connected graph vo graaph hote h jisse hm hr vtx se hr vts tk ja skte h.  pr isko count krna
mushkil kis node se dfs lga h uske order per depend krta h . let say do cycles h graph ki or dono ko ek node
se join kr rkha h (1,2,3) -> (4,5,6) 3->4 jane vali edge hmari problematic edge h kyuki agr hm dfs 1,2,3 se
lgange to ans 1 aaega which is wrong, pr agr 4,5,6 se try kia to ans shi aaega. To hme dfs aise order m call hona 
chaiye ki problem edge jahan khtm hogi vha se dfs shuru kre.
To determine that order
step1 dfs kisi b order m lgae, hmesha group 1 ki vertex stack k top pe aaegi confirm.
to hme confirm top pe vo vts milegi jaha se problem edje shuru ho ri h,
step2 hm graph reverse kr denge, isse cycles m to koi asr ni aaega pr problemtic edge ab (1,2,3)<-(4,5,6)
aise ho jaegi, and kyuki stack m top pe 1,2,3 m se hi kuch hoga pkke se h to 
step 3 stack k pop krne k order se hm dfs lgaenge or shi ans aa jaega*/

    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                dfs1(adj,i,vis,st);
            }
        }
        //reverse graph
        ArrayList<ArrayList<Integer>> ngraph = new ArrayList<>();
        for(int i = 0; i < V; i++){
            ngraph.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++){
            for(int nbr : adj.get(i)){
                ngraph.get(nbr).add(i);
            }
        }
        vis = new boolean[V];
        int count = 0;
        while(st.size() > 0){
            int src = st.pop();
            if(vis[src] == false){
                dfs2(ngraph,src,vis);
                count++;
            }
                
        }
        return count;
        
    }
    
    public static void dfs1(ArrayList<ArrayList<Integer>> adj,int src, boolean[] vis,Stack<Integer> st){
        vis[src] = true;
        
        for(int nbr : adj.get(src)){
            if(vis[nbr] == false)
                dfs1(adj,nbr,vis,st);
        }
        st.push(src);
    }
    
     public static void dfs2(ArrayList<ArrayList<Integer>> adj,int src, boolean[] vis){
        vis[src] = true;
        
        for(int nbr : adj.get(src)){
            if(vis[nbr] == false)
                dfs2(adj,nbr,vis);
        }
        
    }
}
