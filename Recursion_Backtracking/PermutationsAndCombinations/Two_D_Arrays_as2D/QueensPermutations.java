package Recursion_Backtracking.PermutationsAndCombinations.Two_D_Arrays_as2D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueensPermutations {
    public static void queensPermutations(int qpsf, int tq, int row, int col, String asf, boolean[] queens) {
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
                System.out.println();
                
            }
            return;
        }
        int nr = row;
        int nc = col;
        String cl = ""; //change line
        
        if(col == tq-1){
            nr++;
            nc=0;
            cl += "\n";
            
        }
        else{
            cl+= "\t";
            nc++;
            
        }
        
        for(int i = 0; i < queens.length; i++){
            if(queens[i] == false){
                queens[i] = true;
                queensPermutations(qpsf+1,tq,nr,nc,asf+"q"+(i+1)+cl,queens);  
                queens[i] = false;
            }
        }
        queensPermutations(qpsf,tq,nr,nc,asf+"-"+cl,queens);
        
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
