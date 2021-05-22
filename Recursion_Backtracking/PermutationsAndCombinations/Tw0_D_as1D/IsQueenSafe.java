package Recursion_Backtracking.PermutationsAndCombinations.Tw0_D_as1D;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class IsQueenSafe {
    public static boolean IsQueensafe(boolean[][] chess, int row, int col) {
        for(int i = col-1; i >= 0; i--){ // for left
            if(chess[row][i]){
                return false;
            }
        }
        for(int i = row-1; i >= 0; i--){ // for top
            if(chess[i][col]){
                return false;
            }
        }
        for(int i = row-1,j = col-1; i >= 0 && j >= 0; i--,j--){ // for left diag
            if(chess[i][j]){
                return false;
            }
        }
        for(int i = row-1,j = col+1; i >= 0 && j < chess.length; i--,j++){ // for top
            if(chess[i][j]){
                return false;
            }
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueensafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nqueens(0, n, chess, -1);
    }
}
