package Recursion_Backtracking;

import java.util.Scanner;

public class CrossWord_Puzzle {
    public static void solution(char[][] arr, String[] words, int vidx){
		if(vidx == words.length){
		    print(arr);
		    return;
		}
		
		String word = words[vidx];
		for(int i = 0; i < arr.length; i++){
		    for(int j = 0; j < arr[0].length; j++){
		        if(arr[i][j] == '-' || arr[i][j] == word.charAt(0)){
		            if(checkvertical(arr,word,i,j)){
		                boolean[] vis = new boolean[word.length()];
		                placevertical(arr,word,i,j,vis);
		                solution(arr,words,vidx+1);
		                removevertical(arr,word,i,j,vis);
		            }
		            if(checkhorizontal(arr,word,i,j)){
		                boolean[] vis = new boolean[word.length()];
		                placehorizontal(arr,word,i,j,vis);
		                solution(arr,words,vidx+1);
		                removehorizontal(arr,word,i,j,vis);
		            }
		        }
		    }
		}

	}
	public static void removevertical(char[][] arr,String word,int row,int col,boolean[] vis){
	    int i = row;
	    while(i-row < word.length()){
	        if(vis[i-row]){
	            arr[i][col] = '-';
	        }
	        
	        i++;
	        }
	    
	}
	public static void placevertical(char[][] arr,String word,int row,int col,boolean[] vis){
	    int i = row;
	    while(i-row < word.length()){
	        if(arr[i][col] == '-'){
	            vis[i-row] = true;
	        }
	        arr[i][col] = word.charAt(i-row);
	        i++;
	        
	    }
	    
	}
	public static boolean checkvertical(char[][] arr,String word,int row,int col){
	    int i = row;
	    while(i-row < word.length()){
	        if(i == arr.length){
	            return false;
	        }
	        if(arr[i][col] == '-' || arr[i][col] == word.charAt(i-row)){
	            i++;
	            continue;
	        }
	        else{
	            return false;
	        }
	        
	    }
	    return true;
	}
	
	public static void removehorizontal(char[][] arr,String word,int row,int col,boolean[] vis){
	    int i = col;
	    while(i-col < word.length()){
	       if(vis[i-col]){
	            arr[row][i] = '-';
	        }
	        
	        i++;
	    }
	    
	}
	
	public static void placehorizontal(char[][] arr,String word,int row,int col,boolean[] vis){
	    int i = col;
	    while(i-col < word.length()){
	       if(arr[row][i] == '-'){
	            vis[i-col] = true;
	        }
	        arr[row][i] = word.charAt(i-col);
	        i++;
	    }
	    
	}
	
	
	public static boolean checkhorizontal(char[][] arr,String word,int row,int col){
	    int i = col;
	    while(i-col < word.length()){
	        if(i == arr[0].length){
	            return false;
	        }
	        if(arr[row][i] == '-' || arr[row][i] == word.charAt(i-col)){
	            i++;
	            continue;
	        }
	        else{
	            return false;
	        }
	        
	    }
	    return true;
	}

	
	public static void print(char[][] arr){
		for(int i = 0 ; i < arr.length; i++){
			for(int j = 0 ; j < arr.length; j++){
				System.out.print(arr[i][j]);
			}
                  System.out.println();
		}
		
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		char[][] arr = new char[10][10];
		for(int i = 0 ; i < arr.length; i++){
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int n = scn.nextInt();
		String[] words = new String[n];
		for(int i = 0 ; i  < words.length; i++){
			words[i] = scn.next();
		}
        scn.close();
		
		solution(arr,words,0);

	}
}
