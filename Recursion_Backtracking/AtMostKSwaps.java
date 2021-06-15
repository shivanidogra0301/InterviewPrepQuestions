package Recursion_Backtracking;

import java.util.Scanner;

public class AtMostKSwaps {
    static String max;
	public static void findMaximum(String str, int k) {
	    if(Integer.parseInt(str) > Integer.parseInt(max)){
	        max = str;
	    }
	    if(k == 0){
	        return;
	    }
		
		for(int i = 0; i < str.length(); i++){
		    for(int j = i+1; j < str.length(); j++){
		        char ch1 = str.charAt(i);
		        char ch2 = str.charAt(j);
		        if(ch1 < ch2){
		            String swapped = swap(str,i,j);
		            findMaximum(swapped,k-1);
		        }
		        
		    }
		}
	}
	
	public static String swap(String str, int i, int j){
	     char ch1 = str.charAt(i);
		 char ch2 = str.charAt(j);
		  
		  String left = str.substring(0,i);
		  String  mid = str.substring(i+1,j);
		  String right = str.substring(j+1);
		  return left + ch2 + mid + ch1+ right;
	} 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		int k = scn.nextInt();
		 max = str;
		findMaximum(str, k);
        scn.close();
		System.out.println(max);
	}
}
