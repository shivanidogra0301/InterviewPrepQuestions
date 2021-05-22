package Arrays;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int[] arr = new int[num1.length()+num2.length()];
        
        for(int i = num1.length()-1; i >= 0; i--){
            for(int j = num2.length()-1; j >= 0; j--){
                int idx1 = i + j;
                int idx2 = i + j + 1;
                int val = (num1.charAt(i) - '0') * (num2.charAt(j)-'0');
                val += arr[idx2];
                
                int quo = val/10;
                int rem = val%10;
                
                arr[idx1] += quo;
                arr[idx2] = rem;
            }
        }
        String ans = "";
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0 && ans.length() == 0){
                continue;
            }
            ans+= arr[i];
        }
        if(ans.length() == 0){
            return  "0";
        }
        else{
            return ans;
        }
    }
}
