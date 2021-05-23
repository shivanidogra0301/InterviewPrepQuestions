package Recursion_Backtracking.PermutationsAndCombinations;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KnightsCombinations {
    public static boolean IsKnightSafe(boolean[][] chess, int i, int j) {
    
        if(i-2>= 0){
            if(j-1 >= 0){
                if(chess[i-2][j-1]){
                    return false;
                }
            }
            if(j+1 < chess.length){
                if(chess[i-2][j+1]){
                    return false;
                }
            }
        }
        if(i-1 >= 0){
            if(j-2 >= 0){
                if(chess[i-1][j-2]){
                    return false;
                }
            }
            if(j+2 < chess.length){
                if(chess[i-1][j+2]){
                    return false;
                }
            }
            
        }
        return true;
        
    }

    public static void nknights(int kpsf, int tk, boolean[][] chess, int lcno) {
        if (kpsf == tk) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "k\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsKnightSafe(chess, row, col)) {
                chess[row][col] = true;
                nknights(kpsf + 1, tk, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nknights(0, n, chess, -1);
    }
}
