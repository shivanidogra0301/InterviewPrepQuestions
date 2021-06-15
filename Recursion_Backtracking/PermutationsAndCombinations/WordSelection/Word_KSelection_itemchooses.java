package Recursion_Backtracking.PermutationsAndCombinations.WordSelection;

import java.util.HashSet;
import java.util.Scanner;

public class Word_KSelection_itemchooses {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
          String str = scn.nextLine();
          int k = scn.nextInt();
          
          HashSet<Character> unique = new HashSet<>();
          String ustr = "";
          for(char ch : str.toCharArray()){
              if(unique.contains(ch)== false){
                  unique.add(ch);
                  ustr+=ch;
              }
          }
          scn.close();
          
          combination(ustr,0,k,"",-1);
    }
    
     public static void combination(String ustr,int ssf, int ts, String asf,int li ){    
         if(ssf == ts){
             System.out.println(asf);
             return;
         }
            for(int i = li+1; i < ustr.length(); i++){
                char ch = ustr.charAt(i);
                combination(ustr,ssf+1,ts,asf+ch,i);
            }
            
        }
}
