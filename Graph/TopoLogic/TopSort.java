package Graph.TopoLogic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopSort {
    /* jo node kisipe dependent h vo last m aaegi jese ki agr 1->2->3 given h to isme 3 jo h
    uski dependency 1,2 dono pe h a to vo 1,2, k bad hi aaega iss ordering ko topological sort khte h
    
    this sorting is only valid for DIRECTED ACYCLIC graph, kyuki jis graph m cycle hoti h usmehr node
    ki pe dependent hoti h, hme koi b node aisi ni milegi jisko dependency 0 ho jisse sorting
     start kr ske , or undirected graph ek trike se cyclic hi hota h to vha b valid ni hogi
    
     ITERATIVE WAY  kahns algo
     hm phle hr node ki dependency calculate kr lenge i.e uspe kitni edges aa ri h uska array bn lenge
     fr vo sari node jiski dependency 0 h vo queue m dal denge
     then remove krke print, fr uske nbrs jo honge un sbki dependency 1 km ho jaegi  ho jaegi ab jo 0 honge same
     kaam krenge.

     agr last m sari node print nhi hui to mtlb cycle present h, to can be used for cycle detection
     */

    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        int[] ans = new int[V];
        for(int i = 0; i < V; i++){
            for(int nbrs : adj.get(i)){
                indegree[nbrs]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        for(int i =0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        while(q.size() > 0){
            int rem = q.remove();
            
            ans[idx] = rem;
            idx++;
            
            for(int nbrs : adj.get(rem)){
                indegree[nbrs]--;
                
                if(indegree[nbrs] == 0){
                    q.add(nbrs);
                }
            }
        }
        
        return ans;
    }

    /* RECURSIVE WAY isme hm dfs lgate h ans post order m stack m dalte jate h,kyuki dfs work aise krta h
    least dependent se most dependent node tk jata h jb hm vha tk phoch gye to stack m dal denge*/



}
