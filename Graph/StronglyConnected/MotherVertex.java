package Graph.StronglyConnected;
import java.util.ArrayList;
import java.util.Stack;


public class MotherVertex {
    /* hm normal dfs lgaenge jo node stack k top pe hogi srf usi ko check krenge ki vo mother vertex h
    ya ni, vhi hmara ans hoga;
    why?
    ab hmare pass 4 case bnte h
        top         rest of stack
    1.  present     not present
    2. present      present
    3. not present  not present
    4. not present  present
    isme shuru k teen case to hmari algo shi ans de degi, agr wrong aaega to ye ki hm aise kh skte h agr top
    mother vertex ni h to rest of stack m b mother vertex ni hogi
    let say rest of stack m mother vertex h, 3
    2 cases top se uss vertex pe edge h ya ni, agr edge hoti to ofcourse top b mother vertex hoti to 
    ye case ni lenge, ab hme pta top se uss vtx pe edge ni hi (2nd case), and kyuki(ros) vo vts mother vtx h
    to usse top tk pkka ek edge hogi, to agr ye case h, to there is no chance ki 3 stack k top ni aaega.
    so hence last case kbhi possible ni ho skta
    */
    static int count;
    public int findMotherVertex(int V, ArrayList<ArrayList<Integer>>adj)
    {
        Stack<Integer> st = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(visited[i] == false)
            // fill the stack
                dfs(adj,i,visited,st);
        }
        visited = new boolean[V];
        int src = st.pop();
        count = 0;
        // check uss vtx se hr jgah ja skte h yani
        dfs(adj,src,visited);
        if(count == V){
            return src;
        }
        else{
            return -1;
        }
        
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src,boolean[] visited,Stack<Integer> st){
        visited[src] = true;
        for(int nbrs : adj.get(src)){
            if(visited[nbrs]== false){
                dfs(adj,nbrs,visited,st);
            }
        }
        st.push(src);
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int src,boolean[] visited){
        visited[src] = true;
        count++;
        for(int nbrs : adj.get(src)){
            if(visited[nbrs]== false){
                dfs(adj,nbrs,visited);
            }
        }
    }
}
