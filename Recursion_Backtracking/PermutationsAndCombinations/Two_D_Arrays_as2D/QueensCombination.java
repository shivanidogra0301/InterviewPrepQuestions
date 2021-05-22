package Recursion_Backtracking.PermutationsAndCombinations.Two_D_Arrays_as2D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueensCombination {
    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            return;
        }
        
        String yans=asf;
        String nans=asf;
        int nr = row;
        int nc = col;
        if(col == tq -1){
            nc=0;
            nr++;
            yans+= "q\n";
            nans+="-\n";
        }
        else{
            nc++;
            yans += "q";
            nans += "-";
        }
        
        System.out.println(yans);
        queensCombinations(qpsf+1,tq,nr,nc,yans);
        queensCombinations(qpsf,tq,nr,nc,nans);
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}
