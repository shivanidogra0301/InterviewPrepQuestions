package Recursion_Backtracking.PermutationsAndCombinations.Tw0_D_as1D;
import java.io.*;

public class QueenPermutations {
   



    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
         for(int i = col-1; i >= 0; i--){ // for left
            if(chess[row][i] != 0){
                return false;
            }
        }
        for(int i = col+1; i< chess.length; i++){ // for right
            if(chess[row][i]!= 0){
                return false;
            }
        }
        for(int i = row-1; i >= 0; i--){ // for top
            if(chess[i][col]!= 0){
                return false;
            }
        }
        for(int i = row+1; i< chess.length; i++){ // for bottom
            if(chess[i][col]!= 0){
                return false;
            }
        }
        for(int i = row-1,j = col-1; i >= 0 && j >= 0; i--,j--){ // for left diag up
            if(chess[i][j]!= 0){
                return false;
            }
        }
        for(int i = row+1,j = col+1; i < chess.length && j < chess.length; i++,j++){ // for left diag down
            if(chess[i][j]!= 0){
                return false;
            }
        }
        for(int i = row-1,j = col+1; i >= 0 && j < chess.length; i--,j++){ // for right diag up
            if(chess[i][j]!= 0){
                return false;
            }
        }
        for(int i = row+1,j = col-1; i < chess.length && j >= 0; i++,j--){ // for right diag up
            if(chess[i][j]!= 0){
                return false;
            }
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        if(qpsf == tq){
            for(int r = 0; r < chess.length; r++){
                for(int c = 0; c < chess.length; c++){
                if(chess[r][c] != 0){
                    System.out.print("q"+chess[r][c]+"\t");
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
            int row = i / tq;
            int col = i % tq;
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
