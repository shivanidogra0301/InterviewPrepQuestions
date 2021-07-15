package HashMaps;

import java.util.HashMap;
/* kitne b unique characters ho skte h doesnot matter mtlb map ka
size kitna b ho skta h, bus sare char ki freq 1 honi chiaye*/
public class LongestSubstringHavingUniqueCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;
        int len = 0;
        while(true){
            boolean flag1 = false;
            boolean flag2 = false;
            
            
            //aquire till invalid
            
            while(i < s.length() - 1){
                i++;
                flag1 = true;
                
                char ch = s.charAt(i);
                map.put(ch,map.getOrDefault(ch,0)+1);
                if(map.get(ch) == 2){
                    break;
                }
                else{
                    int l = i - j;
                    len = Math.max(len, l);
                }
            }
            //release to make valid
            
            while(j < i){
                flag2 = true;
                
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch) == 1){
                    break;
                }
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return len;
    }
}
