package Recursion_Backtracking.PermutationsAndCombinations.Coin_Change;

import java.io.BufferedReader;
import java.io.InputStreamReader;
class Coin_Change_Combination2{
/* coins chooses to come or not, but here we can choose every coins infinitely
i.e id(2,3,7) target is 6 then ans could be 2,2,2*/
    public static void coinChange(int i, int[] coins, int amtsf, int tamt, String asf) {
        if(i == coins.length){
            if(amtsf == tamt){
                System.out.println(asf+".");
            }
            return;
        }
        
        for(int j = tamt / coins[i]; j >= 1; j--){
            String part = "";
            for(int k = 0; k < j; k++){
                part += coins[i]+"-";
            }
            coinChange(i+1,coins,amtsf + coins[i] * j,tamt,asf+part);
            
        }
        coinChange(i+1,coins,amtsf,tamt,asf);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        int amt = Integer.parseInt(br.readLine());
        coinChange(0, coins, 0, amt, "");
    }
}