package Graph;
import java.util.*;
public class MinSwapsToMakeStringIdentical {
    public int kSimilarity(String s1, String s2) {
        StringBuilder sb = new StringBuilder(s1);
        Queue<StringBuilder> q = new LinkedList<>();
        q.add(sb);
        HashSet<String> set = new HashSet<>();
        int count = 0;
        set.add(sb.toString());
        while(q.size() > 0){
            int size = q.size();
    
            while(size-->0){
                
                StringBuilder rem = q.remove();
                if(rem.toString().equals(s2)){
                    return count;
                }
                int idx = -1;
                for(int i = 0; i < s1.length(); i++){
                    if(rem.charAt(i) != s2.charAt(i)){
                        idx = i;
                        break;
                    }
                }
                System.out.println(idx);
                for(int i = 0; i < s1.length(); i++){
                    
                    if(rem.charAt(i) == s2.charAt(idx)){
                        StringBuilder ns = new StringBuilder(rem);
                        char temp = ns.charAt(idx);
                        ns.setCharAt(idx,s2.charAt(idx));
                        ns.setCharAt(i,temp);
                        if(!set.contains(ns.toString())){
                            q.add(ns);
                            set.add(ns.toString());
                        }
                        // System.out.println(ns.toString());
                        
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
