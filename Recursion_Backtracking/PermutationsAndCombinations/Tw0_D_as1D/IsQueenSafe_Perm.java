package Recursion_Backtracking.PermutationsAndCombinations.Tw0_D_as1D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IsQueenSafe_Perm {
    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        for(int i = chess[0].length-1; i >= 0; i--){ // for left
            if(chess[row][i] > 0){
                return false;
            }
        }
        for(int i = chess.length-1; i >= 0; i--){ // for top
            if(chess[i][col]> 0){
                return false;
            }
        }
         for(int i = row-1,j = col-1; i >= 0 && j >= 0; i--,j--){ // for left diag
            if(chess[i][j]> 0){
                return false;
            }
        }
        for(int i = row+1,j = col+1; i < chess.length && j < chess[0].length; i++,j++){ // for left diag
            if(chess[i][j]> 0){
                return false;
            }
        }
        
        
        for(int i = row-1,j = col+1; i >= 0 && j < chess.length; i--,j++){ 
            if(chess[i][j]> 0){
                return false;
            }
        }
        
        for(int i = row+1,j = col-1; i < chess.length && j >= 0; i++,j--){ 
            if(chess[i][j]> 0){
                return false;
            }
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if(qpsf == tq){
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                   if(chess[row][col] > 0){
                       System.out.print("q" + chess[row][col]+"\t");
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
        
        for(int i = 0; i < tq * tq; i++){
            int row = i / chess.length;
            int col = i % chess.length;
            
            if(chess[row][col] == 0 && IsQueenSafe(chess,row,col)){
                chess[row][col] = qpsf+1;
                nqueens(qpsf+1,tq,chess);
                chess[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}
