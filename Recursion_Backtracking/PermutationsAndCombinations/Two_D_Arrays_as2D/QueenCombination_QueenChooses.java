package Recursion_Backtracking.PermutationsAndCombinations.Two_D_Arrays_as2D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class QueenCombination_QueenChooses {
    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        if(qpsf == tq){
             for(int r = 0; r < chess.length; r++){
                for(int c = 0; c < chess.length; c++){
                if(chess[r][c] == true){
                    System.out.print("q\t");
                }
                else{
                    System.out.print("-\t");
                }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
            for(int c = j+1; c < chess.length; c++){ //same row pending columns
                if(chess[i][c] == false){
                    chess[i][c] = true;
                    queensCombinations(qpsf+1,tq,chess,i,c);
                    chess[i][c] = false;
                }
            }
        
        for(int r = i+1; r < chess.length; r++){ //remaining rows all col
            for(int c = 0; c < chess.length; c++){
                if(chess[r][c] == false){
                    chess[r][c] = true;
                    queensCombinations(qpsf+1,tq,chess,r,c);
                    chess[r][c] = false;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}
