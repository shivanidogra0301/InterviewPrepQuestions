package Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
/* vo graph jiski nodes ko agr h do set m divide kr ske such that ek set ki nodes m aaps m koi direct
edge nhi ho usko bipartite graph khte h to isme hm level wise dekhe to hr alternate level ki nodes ko
ek set m dale or kisi b point pe hme visited node na mile to vo graph bipartite hoga
     
point 1 linear graph hmesha bipartite hoga
point 2 cyclic graph m do types ki cycle hoti h
    even length cycle hmesha bi partite hogi kese 1--2
                                                  |  |
                                                  3--4 is case m 1 set1 m gya, 2,3 set 2 m and 4 set 1 m
    even length cycle m last level pe node converge ho jati h to contradict nhi hota

    odd cycle    1
                / \
                2  3
                |  |
                4 - 5 yha 1 level 0 set 1, (2,3) set 2 ab kayde se (4,5) level 1 pe hona chiaye but 4,5 m direct
                edge jisse vo same set pe to ni ho skte, to contradiction aagyi yha last level pe node converge
                ni hoti that is same level ki node m aaps m edge hoti h. isliye no bioartite */

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        // to check for every unconnected node
        for(int i = 0; i < n; i++){
            // vo vala graph jisme ye node h vo process ho chuka h for unconnected graph
            if(vis[i] != -1){
                continue;
            }
            
            Queue<Integer> q = new LinkedList<>();
            //assign this node set 1 10 is basicalyy set 1 random value
            vis[i] = 10; 
            q.add(i);
            
            while(q.size() > 0){
                int rem = q.remove();
                
                int[] nbrs = graph[rem];
                for(int nbr : nbrs){
                    //not visited so give them set diffrent from rem node
                    if(vis[nbr] == -1){
                        q.add(nbr);
                        if(vis[rem] == 10){
                            vis[nbr] = 12;
                        }
                        else{
                            vis[nbr] = 10;
                        }
                    }
                    //if visited, check kis set m dle h, hm nbrs ko same set m ni dal skte
                    else{
                        if(vis[nbr] == vis[rem]){
                            return false;
                        }
                    }
                }
                
            }
        }
            return true;
        
    }
}
