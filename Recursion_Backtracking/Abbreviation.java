package Recursion_Backtracking;

import java.util.Scanner;

public class Abbreviation {
    public static void solution(String str, String asf,int count, int pos){
        if(pos == str.length()){
            if(count > 0){
                asf += count;
            }
            System.out.println(asf);
            return;
        }
        
        
        char ch = str.charAt(pos);
        if(count > 0){
            solution(str,asf+count+ch,0,pos+1); //no call mtlb char print but count abhi asf m add ni hua h, to usko ch se phle dalna hoga
        }
        else{
            solution(str,asf+ch,0,pos+1);
        }
         
        solution(str,asf,count+1,pos+1); //yes call h, so count print krna h pr abhi ni kr skte kyuki aage jake kya pta count 2 ho jae to abhi srf count m add hoga
    }
	
    
	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        scn.close();
        solution(str,"",0,0);
    }
}
