package Recursion_Backtracking;

import java.util.Scanner;

public class Max_Score {
    public static int solution(String[] words, int[] farr, int[] score, int idx) {
	    if(idx == words.length){
	        return 0;
	    }
	    int noans = 0 + solution(words,farr,score,idx+1); //word is not included
	    
	    int yesans = 0;
	    //check if word can be included i.e usme jo char h uski freq available h ya ni
	    String word = words[idx];
	    boolean flag = true;
	    for(int i = 0; i < word.length(); i++){
	        char ch = word.charAt(i);
	        if(farr[ch-'a'] == 0){
	            flag = false; //char present in word is not in freq arr
	        }
	        farr[ch - 'a']--;
	        yesans += score[ch - 'a'];
	    }
	    int scorifincluded = 0;
	    if(flag) //is word ko include ni kr skte to aage calls ni lgengi
	    scorifincluded =  yesans + solution(words,farr,score,idx+1); // khud ka calc krke baki recursion se pucha
	    
	    for(int i = 0; i < word.length(); i++){
	        char ch = word.charAt(i);
	        
	        farr[ch - 'a']++;
	        
	    }
	    
	    return Math.max(noans,scorifincluded);
	    
	}

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int nofWords = scn.nextInt();
		String[] words = new String[nofWords];
		for(int i = 0 ; i < words.length; i++) {
			words[i] = scn.next();
		}
		int nofLetters = scn.nextInt();
		char[] letters = new char[nofLetters];
		for (int i = 0; i < letters.length; i++) {
			letters[i] = scn.next().charAt(0);
		}
		int[] score = new int[26];
		for (int i = 0; i < score.length; i++) {
			score[i] = scn.nextInt();
		}
        scn.close();
		if (words == null || words.length == 0 || letters == null || letters.length == 0 || score == null
				|| score.length == 0) {
			System.out.println(0);
			return;
		}
		int[] farr = new int[score.length];
		for (char ch : letters) {
			farr[ch - 'a']++;
		}
		System.out.println(solution(words, farr, score, 0));

	}
}
