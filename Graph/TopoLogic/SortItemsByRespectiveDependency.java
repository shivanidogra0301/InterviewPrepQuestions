package Graph.TopoLogic;
import java.util.*;
public class SortItemsByRespectiveDependency {
/*
we are given some groups for vertices and condition same group val ek sath print honge chaiye,
plus hmko extra column dia h, before ka which isme jo items h vo uss i se phle print hone chaiye
to basically hme ek graph bnana h accoriding to given condition and topological sort lga denge

GRAPH CONSTRUCTION
to handle grouping of nodes we will wrap each group with start node and end node 
formula = sn = n + groupid * 2, en = n + groupid * 2 + 1 where n is total nodes, groupid is idnof that node
let say 4 node h, 2 node ko ek group m dala h
node groupid
0   1
1   0       Here, hm 0,2 ko ek group m wrap krenge, or uski sn = 4 + 1 * 2 = 6, en = 4 + 1 * 2+1 =7
2   1
3   0

now to make this, hr node ka sn , en calculate kro, or sn to node ek edge, node to en ek edge dal do

before table ko uske krke graph m edge dalni h
4 cases
both node does not contains any group = simple edge dl jaegi before to current
before is present in a group, to edge dlegi ennodeofbefore to cur
cur is present in a group, to edge dlegi before to curnodestartnode
both are in group, to edge is before ki end node to cur ki start node

graph created

TOPSORT cannot use simple KAHNs algo, kyuki usme group ki property violate hori thi
what we want ki ek group m enter kia to uski sari node phle print ho,

normal topsort m, its dfficult to detect cycle

so last option is, mixture of both, what we will do, jis node ki indegree o, h usse dfs lgadenge
and uske nbr ki indegree km krdenge, so basically we are  doing kahns algo, but instead queue, we
use recursion dfs.

*/
    HashMap<Integer,ArrayList<Integer>> graph;
    int[] ans;
    int idx;
    public void addEdge(int src, int nbr){
        ArrayList<Integer> list = graph.get(src);
        list.add(nbr);
        graph.put(src,list);
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        graph = new HashMap<>();
        int totalNodes = n + m * 2;
        // System.out.println(totalNodes);
        for(int i = 0; i < totalNodes; i++ ){
            graph.put(i,new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            if(group[i] != -1){
                int sn = n + 2 * group[i];
                int en = n + (2 * group[i]+1);
                // System.out.println(sn+" "+en);
                addEdge(sn,i);
                addEdge(i,en);
            }
        }
        
//         for(int i = 0; i < totalNodes; i++){
//             System.out.println("src "+ i+" "+  graph.get(i) );
            
//         }
        
        //before items
        for(int i = 0; i < beforeItems.size(); i++){
            for(int before : beforeItems.get(i)){
                if(group[i] == -1 && group[before] == -1){
                    addEdge(before,i);
                }
                else if(group[i] == -1){
                    int en = n + (2 * group[before]+1);
                    addEdge(en,i);
                }
                else if(group[before]== -1){
                    int sn = n + 2 * (group[i]);
                    addEdge(before,sn);
                }
                else{
                    if(group[before] == group[i]){
                        addEdge(before,i);
                    }
                    else{
                        int enbefore = n + (2 * group[before]+1);
                        int sni = n + 2 * (group[i]);
                        addEdge(enbefore,sni);
                    }
                }
            }
        }

        ans = new int[n];
        idx= 0;
       int[] indegree = new int[totalNodes];
        for(int i = 0; i < totalNodes; i++){
            for(int nbr : graph.get(i)){
                indegree[nbr]++;
            }
        }
        for(int i = 0; i < totalNodes; i++){
            if(indegree[i] == 0){
                dfs(i,indegree,n);
            }
        }
        if(idx == n){
            return ans;
        }
        return new int[0];
        
    }
   
    public void dfs(int src, int[]indegree, int n){
       if(src < n){
           ans[idx] = src;
           idx++;
       }
        
        indegree[src]--;
        
        for(int nbr : graph.get(src)){
            indegree[nbr]--;
            if(indegree[nbr]== 0){
                dfs(nbr,indegree,n);
            }
        }
        
    }
}
