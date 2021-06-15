package Recursion_Backtracking;

import java.util.Scanner;

public class LexicographicalOrder {
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        scn.close();
		for(int i = 1; i <= 9; i++){
		    lexi(i,n);
		}
	}
	
	public static void lexi(int j, int n){
	    if(j > n){
	        return;
	    }
	    System.out.println(j);
	    for(int i = 0; i <= 9; i++){
	        lexi(j * 10 + i,n);
	    }
	}
}
