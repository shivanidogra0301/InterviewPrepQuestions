package Arrays;

public class DigitMultiplier {
    public static String getSmallest(Long N) {
        // code here
        if(N == 1){
            return "1";
        }
        String ans = "";
        int i = 9;
        while(i >= 2){
            if(N == 1){
                break;
            }
            if(N % i == 0 ){
                ans = i + ans;
                N = N / i;
            }
            else{
                i--;
            }
        }
        
        if(N != 1 ){
            return "-1";
        }
        
        else{
            return ans;
        }
        
    }
}
