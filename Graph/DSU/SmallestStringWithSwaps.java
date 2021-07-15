package Graph.DSU;
import java.util.*;

/*
 we are given indices of string , jisko hm swap kr skte h, to hme btana h kitne b swaps krke
 smallest string kya aaegi
 logic :  1,2  2,3 do pairs h mtlb 1,2,3 ko aaps m swap kr skte h
 to hm bss sare pairs ka union nikal lenge
 or hashmap m leader vs uss connected components jo indices h un charactet ki priorityqueue
 for example abcdef (0,1) (1,2) (3,4) (5,1) => (0,1,2,5) (3,4)
 lets say phle component ka leader 0 h to map m 0 vs (a,b,c,f) and 3 vs d,e
 rkha hoga, kyuki hme smallest chaiye to hm priority queue use krlenge
*/
public class SmallestStringWithSwaps {
    int[] par;
    int[] rank;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        par = new int[n];
        rank = new int[n];
        
        for(int i = 0; i < n; i++){
            par[i] = i;
            rank[i] =1;
        }
        
        for(int i = 0; i < pairs.size(); i++){
            int x = pairs.get(i).get(0);
            int y = pairs.get(i).get(1);
            
            union(x,y);
        }
        HashMap<Integer,PriorityQueue<Character>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            int leader = find(par[i]);
            if(!map.containsKey(leader)){
                PriorityQueue<Character> pq = new PriorityQueue<>();
                pq.add(s.charAt(i));
                map.put(leader,pq);
            }
            else{
                PriorityQueue<Character> pq = map.get(leader);
                pq.add(s.charAt(i));
                map.put(leader,pq);
            }
        }
        
        String ans = "";
        
        for(int i = 0; i < n; i++){
            int key = find(par[i]);
            ans += map.get(key).remove();
        }
        
        return ans;
        
    }
    
    
    public int find(int x){
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
