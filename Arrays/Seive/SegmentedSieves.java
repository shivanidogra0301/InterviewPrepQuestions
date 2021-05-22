package Arrays.Seive;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class SegmentedSieves {

    public static ArrayList<Integer> segment(int x, int y){
        boolean[] arr = new boolean[y-x +1];
        ArrayList<Integer> prime = new ArrayList<>();
        prime = seive((int)Math.sqrt(y));
        // System.out.println(prime);
        for(int p : prime){
            int start = (int)Math.ceil(x*1.0/p) * p;
            if(p >= x && p <= y){
                start = p + p;
            }
            for(int j = start; j <= y; j+= p){
                arr[j-x] = true;
            }

        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = x; i <= y;i++){
            if(arr[i-x] == false && i != 1){
                ans.add(i);
            }
        }
        return ans;
        
    }
    public static ArrayList<Integer> seive(int N){
        boolean[] arr = new boolean[N +1];
        for(int i = 2; i * i <= N; i++){
            if(arr[i] == false){
                for(int j = i * i; j <= N; j+= i){
                    arr[j] = true;
                }
            }
        }
        ArrayList<Integer> prime = new ArrayList<>();
        for(int i = 2; i <= N; i++){
            if(arr[i] == false){
                prime.add(i);
            }
        }

        return prime;
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        
        PrintWriter out = new PrintWriter(System.out);
        while(t > 0){
            int x = scn.nextInt();
            int y = scn.nextInt();
            ArrayList<Integer> ans = segment(x,y);
            for(int n : ans){
            out.println(n);
            }
            t--;
        }
        out.close();
        scn.close();
        
        
        

    }
}
