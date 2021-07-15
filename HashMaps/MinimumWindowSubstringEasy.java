package HashMaps;

import java.util.*;

public class MinimumWindowSubstringEasy {
    public  static String findSubString( String str) {
        HashSet<Character> set = new HashSet<>();
        
        for(int i = 0; i < str.length(); i++){
            set.add(str.charAt(i));
        }
        int ucnt = set.size();
        HashMap<Character,Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        String ans = "";
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            while(i < str.length()-1 && map.size() < ucnt){
                i++;
                char ch = str.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                flag1 = true;
            }
            
            while(j < i && map.size() == ucnt){
                String pans = str.substring(j+1,i+1);
                if(ans.length() == 0 || pans.length() < ans.length()){
                    ans = pans;
                }
                
                j++;
                char ch = str.charAt(j);
                
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    map.put(ch,map.getOrDefault(ch,0)-1);
                }
                flag2 = true;
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return ans;
    }

public static void main(String[] args){
    String str = "GEEKSGEEKSFOR";
    System.out.println(findSubString(str));
}
    


    
}

