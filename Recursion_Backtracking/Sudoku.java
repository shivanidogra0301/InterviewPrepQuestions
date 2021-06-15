package Recursion_Backtracking;
import java.util.*;
public class Sudoku {

    public static void display(int[][] board){
    for(int i = 0; i < board.length; i++){
      for(int j = 0; j < board[0].length; j++){
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }
    public static boolean isvalid(int[][]board,int val,int row, int col){
    for(int i = 0; i < board.length; i++){
        if(board[i][col] == val){
            return false;
        }
    }
    for(int i = 0; i < board[0].length; i++){
        if(board[row][i] == val){
            return false;
        }
    }
    
    int sr = row/3 * 3;
    int sc = col/3 * 3;
    
    for(int i = 0; i < 3; i++){
        for(int j = 0; j < 3; j++){
            if(board[sr+i][sc+j] == val){
                return false;
            }
        }
    }
    return true;
    
    
}
  public static void solveSudoku(int[][] board, int i, int j) {
    if(i == board.length){
        display(board);
        return;
    }
    int nr = i;
    int nc = j;
    if(nc == board[0].length-1){
        nc = 0;
        nr++;
    }
    else{
        nc++;
    }
    if(board[i][j] != 0){
        solveSudoku(board,nr,nc);
    }
    else{
        for(int val = 1; val <= 9; val++){
            if( isvalid(board,val,i,j)){
                board[i][j] = val;
                solveSudoku(board,nr,nc);
                board[i][j] = 0;
            }
            
        }
    }
    
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }
    scn.close();

    solveSudoku(arr, 0, 0);
  }
}


