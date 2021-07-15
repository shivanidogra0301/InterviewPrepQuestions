package HashMaps;

import java.util.HashMap;
import java.util.Scanner;

/* isme repeated chars ki count kitni b ho skti h,bss jo unique charactes h uska size = k 
k equal hona chaiye isliye isme size check krte h*/ 
public class LongestSubstringWithexactlyKuniquechars {
    public static int solution(String s, int k){
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
                if(map.size() > k){
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
                if(map.get(ch) == 1){
                    map.remove(ch);
                }
                else{
                    map.put(ch,map.getOrDefault(ch,0)-1);
                }
                
                if(map.size() == k){
                    break;
                }
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return len;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        scn.close();
		System.out.println(solution(str,k));
	}
}
