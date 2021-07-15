package HashMaps.Anagrams;
import java.util.*;

/*
    anagrams vo do string hoti h, jiska hashmap same bnta h, yani char ka count same ho ta h,
    to hm phle p size ka do hashmap bna lenge, fr ek ek kke nya char dalnege, or pichla remove kr denge and c
    check krenge ki vo p k hashmap jesa same h, agr h to count++
*/
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length()){
            System.out.println("short");
            return new ArrayList<>();
        }
        HashMap<Character,Integer> smap = new HashMap<>();
        HashMap<Character,Integer> pmap = new HashMap<>();
        int i;
        
       for(i = 0; i < p.length(); i++){
           char sch = s.charAt(i);
           char pch = p.charAt(i);
           pmap.put(pch,pmap.getOrDefault(pch,0)+1);
           smap.put(sch,smap.getOrDefault(sch,0)+1);
        }
        ArrayList<Integer> list = new ArrayList<>();
        
       
        for(i = p.length(); i < s.length(); i++){
            if(smap.equals(pmap)){
                System.out.println("true");
                list.add(i-p.length());
            }
            
            char cha = s.charAt(i);
            smap.put(cha,smap.getOrDefault(cha,0)+1);
            
            char chr = s.charAt(i-p.length());
            if(smap.get(chr) == 1){
                smap.remove(chr);
            }
            else{
                smap.put(chr,smap.get(chr)-1);
            }
        }
        
        if(smap.equals(pmap)){
                list.add(i-p.length());
        }
        
        return list;
        
    }
}
