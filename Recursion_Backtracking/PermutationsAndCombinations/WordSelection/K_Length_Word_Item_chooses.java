package Recursion_Backtracking.PermutationsAndCombinations.WordSelection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class K_Length_Word_Item_chooses {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
    
        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
          if (unique.contains(ch) == false) {
            unique.add(ch);
            ustr += ch;
          }
        }
       HashSet<Character> used = new HashSet<>();
       permutation(1,k,used,ustr,"");
      }
      
      public static void permutation(int cs, int ts,HashSet<Character> used,String ustr,String asf ){
          if(cs > ts){
              System.out.println(asf);
              return;
          }
          
          for(int i = 0; i < ustr.length(); i++){
              char ch = ustr.charAt(i);
              if(!used.contains(ch)){
                  used.add(ch);
                  permutation(cs+1,ts,used,ustr,asf+ch);
                  used.remove(ch);
              }
          }
      }
    
}
