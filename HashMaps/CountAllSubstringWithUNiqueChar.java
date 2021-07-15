package HashMaps;

import java.util.HashMap;
import java.util.Scanner;

public class CountAllSubstringWithUNiqueChar {
    /* given string like aabc = all substrings having unique char
    a , a  , (aa ni la skte kyuki repeat char ni aaenge), b, ab ,(aab ni aa skta),
    c, bc , abc ans is 7 */
    public static int solution(String s) {
		HashMap<Character,Integer> map = new HashMap<>();
		 int i = -1;
        int j = -1;
        int count = 0;
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
                    count += i - j;
                }
            }
            //release to make valid
            
            while(j < i){
                flag2 = true;
                
                j++;
                char ch = s.charAt(j);
                map.put(ch,map.getOrDefault(ch,0)-1);
                if(map.get(ch) == 1){
                    count += i - j;
                    break;
                }
                
            }
            if(flag1 == false && flag2 == false){
                break;
            }
        }
        return count;
		
		
		
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
        scn.close();
	}
}
