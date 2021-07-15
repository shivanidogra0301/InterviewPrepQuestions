package Graph.TopoLogic;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K)
    {
        HashMap<Character,HashSet<Character>> graph = new HashMap<>();
        HashMap<Character,Integer> indegree = new HashMap<>();
        // indegree m sare characters dal diye
        for(int i = 0; i < dict.length; i++){
            String st = dict[i];
            for(int j = 0; j < st.length(); j++){
                char ch = st.charAt(j);
                indegree.put(ch,0);
            }
        }
        
        for(int i = 0; i < dict.length - 1; i++){
            String cur = dict[i];
            String next = dict[i+1];
            
            int len = Math.min(cur.length(),next.length());
            
            for(int j = 0; j <  len; j++){
                char ch1 = cur.charAt(j);
                char ch2 = next.charAt(j);
                
                if(ch1 != ch2){
                    // System.out.println(ch1+" "+ch2);
                    if(graph.containsKey(ch1)){
                        HashSet<Character> set = graph.get(ch1);
                        if(set.contains(ch2) == false){
                            indegree.put(ch2,indegree.get(ch2)+1);
                            set.add(ch2);
                            graph.put(ch1,set);
                        }
                    }
                    else{
                        // System.out.println("second");
                        indegree.put(ch2,indegree.get(ch2)+1);
                        HashSet<Character> set = new HashSet<>();
                        set.add(ch2);
                        graph.put(ch1,set);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        
        for(char ch  : indegree.keySet()){
            if(indegree.get(ch) == 0){
                q.add(ch);
            }
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(q.size() > 0){
            char rem = q.remove();
            sb.append(rem);
            count++;
            if(graph.containsKey(rem)){
                HashSet<Character> set = graph.get(rem);
                    for(char ch : set){
                    indegree.put(ch,indegree.get(ch)-1);
                    if(indegree.get(ch) == 0){
                        q.add(ch);
                    }
                }
            }
           
            
        }
        if(count == indegree.size()){
            return sb.toString();
        }
        return "";
        
    }
}
