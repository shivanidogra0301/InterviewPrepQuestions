package Recursion_Backtracking;

import java.util.Scanner;

public class GoldMine {
    static int max = 0;
	static int cmax = 0;
	public static void getMaxGold(int[][] arr){
		
		for(int i = 0; i < arr.length; i++){
		    for(int j = 0; j < arr[0].length; j++){
		        if(arr[i][j] != 0){
		            traversals(arr,i,j);
		            max = Math.max(max,cmax);
		            cmax = 0;
		        }
		    }
		}
		
	}
	
	public static void traversals(int[][] arr,int row,int col){
	    if(row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col] == 0){
	        return;
	    }
	    cmax = cmax + arr[row][col];
	    arr[row][col] = 0;
	    traversals(arr,row-1,col);
	    traversals(arr,row+1,col);
	    traversals(arr,row,col-1);
	    traversals(arr,row,col+1);
	    
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i < arr.length; i++){
			for(int j = 0 ; j  < arr[0].length; j++){
				arr[i][j] = scn.nextInt();
			}
		}
        scn.close();
		getMaxGold(arr);
		System.out.println(max);
	}
}
