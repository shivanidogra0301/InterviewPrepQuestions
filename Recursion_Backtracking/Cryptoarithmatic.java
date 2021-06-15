package Recursion_Backtracking;

import java.util.HashMap;
import java.util.Scanner;

public class Cryptoarithmatic {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.nextLine();
        String s2 = scn.nextLine();
        String s3 = scn.nextLine();
        scn.close();
        HashMap<Character, Integer> charIntMap = new HashMap<>();
        String unique = "";
        for (int i = 0; i < s1.length(); i++) {
          if (!charIntMap.containsKey(s1.charAt(i))) {
            charIntMap.put(s1.charAt(i), -1);
            unique += s1.charAt(i);
          }
        }
    
        for (int i = 0; i < s2.length(); i++) {
          if (!charIntMap.containsKey(s2.charAt(i))) {
            charIntMap.put(s2.charAt(i), -1);
            unique += s2.charAt(i);
          }
        }
    
        for (int i = 0; i < s3.length(); i++) {
          if (!charIntMap.containsKey(s3.charAt(i))) {
            charIntMap.put(s3.charAt(i), -1);
            unique += s3.charAt(i);
          }
        }
    
        boolean[] usedNumbers = new boolean[10];
        solution(unique, 0, charIntMap, usedNumbers, s1, s2, s3);
      }
      
      public static long number(HashMap<Character, Integer> charIntMap,String str){
          long ans = 0;
          
          for(int i = 0; i < str.length(); i++){
              char ch = str.charAt(i);
              int val = charIntMap.get(ch);
                ans = ans * 10 + val;
              
          }
          return ans;
          
      }
    
      
      public static void solution(String unique, int idx, 
                                  HashMap<Character, Integer> charIntMap, boolean[] usedNumbers, 
                                  String s1, String s2, String s3) {
            if(idx == unique.length()){
                long n1 = number(charIntMap,s1);
                long n2 = number(charIntMap,s2);
                long n3 = number(charIntMap,s3);
                
                if(n1 + n2 == n3){
                    for(int i = 0; i < 26; i++){
                        char ch = (char)('a'+i);
                        if(charIntMap.containsKey(ch)){
                            System.out.print(ch+"-"+charIntMap.get(ch)+" ");
                        }
                    }
                    System.out.println();
                }
                return;
            }
            char ch = unique.charAt(idx);
            for(int i = 0; i <= 9; i++){
                if(usedNumbers[i] == false){
                    usedNumbers[i] = true; // to avoid same number
                    charIntMap.put(ch,i);
                    
                    solution(unique,idx+1,charIntMap,usedNumbers,s1,s2,s3);
                    
                    usedNumbers[i] = false;
                    charIntMap.put(ch,-1);
                    
                    
                }
            }
      }
    
}
