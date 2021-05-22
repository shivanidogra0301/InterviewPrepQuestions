package Recursion_Backtracking.PermutationsAndCombinations.One_D_Arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//print Combination
//permuation of similar items is equal to its combination;


public class Combination2 {
    public static void combinations(int[] boxes, int ci, int ti, int lb){
        // write your code here
        if(ci > ti){
            for(int i = 0; i < boxes.length; i++){
                if(boxes[i] == 1){
                    System.out.print("i");
                }
                else{
                    System.out.print("-");
                }
            }
            System.out.println();
            return;
        }
        for(int i = lb+1; i < boxes.length; i++){
            boxes[i] = 1;
            combinations(boxes,ci+1,ti,i);
            boxes[i] = 0;
        }
      }
    
      public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nboxes = Integer.parseInt(br.readLine());
        int ritems = Integer.parseInt(br.readLine());
        combinations(new int[nboxes], 1, ritems, -1);
      }
    
}
