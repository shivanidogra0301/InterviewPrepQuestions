package Recursion_Backtracking.PermutationsAndCombinations.WordSelection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class K_Length_Word_Box_chooses {
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
        Character[] spots = new Character[k];
        permutations(spots,ustr,0,k,0);
    
        
      }
      public static void permutations(Character[] spots,String ustr,int ssf, int ts,int cc ){  
            if(cc == ustr.length()){
                if(ssf == ts){
                    for(int i = 0; i < spots.length; i++){
                        System.out.print(spots[i]);
                    }
                    System.out.println();
                }
                return;
            }
             
             
            char ch = ustr.charAt(cc);
            for(int i = 0; i < spots.length; i++){
                if(spots[i] == null){
                    spots[i] = ch;
                    permutations(spots,ustr,ssf+1,ts,cc+1);
                    spots[i]= null;
                }
            }
            
            permutations(spots,ustr,ssf,ts,cc+1); 
          }
}
