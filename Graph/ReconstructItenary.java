package Graph;
import java.util.*;
class ReconstructItenary{
/*
we have given tickets with src and des and hme ek valid path btana h for user
such that usne sari tickets use kri h, and lexicographically smaller btana h,
lexicographical order ko hm priorityQueue se handle kr lenge
now kyuki ek ticket to ek bare use kr skte h, to basically hme hr edge ko
ek bar travel krna h, for marking visited to edge we remove the edge from graph

now the ans is added in postorder using addFirst, kyuki agr preorder m 
add kia to ek case aise ho skta h jisse hm ek node pe gye or vha 
stuck hogye, to hmara ans to jane se phle update hora h, to isse
glt ans aa skta h, pr agr hm backtrack krke addFirst krenge to jo node
hme stuck kregi vo last m hi dlegu which is the valid ans
for e.g:   JFK
        /       \ \
    ATL         SFO
    Here if we go in preorder, to hm jfk se atl gye,then sfo to ans
    hoga jfk atl sfo jfk which is wrong kyuki atl se sfo edge h hi ni
    but agr post order m add first krenge JFK SFO JFK ATL


*/
    HashMap<String,PriorityQueue<String>> graph;
    LinkedList<String> ans;
    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
       for(int i = 0; i < tickets.size(); i++){
           String src = tickets.get(i).get(0);
           String des = tickets.get(i).get(1);
           if(graph.containsKey(src)){
               PriorityQueue<String> nbrs = graph.get(src);
               nbrs.add(des);
               graph.put(src,nbrs);
           }
           else{
               PriorityQueue<String> nbrs = new PriorityQueue<>();
               nbrs.add(des);
               graph.put(src,nbrs);
           }
       }
        ans = new LinkedList<>();
        dfs("JFK");
        return ans;
    
    }
    
    public  void dfs(String src){
        
        PriorityQueue<String> nbrs = graph.getOrDefault(src,new PriorityQueue<>());
        // System.out.println(nbrs.size());
        while(nbrs.size() > 0){
            String nbr = nbrs.remove();
            dfs(nbr);
        }
        ans.addFirst(src);
    }
}