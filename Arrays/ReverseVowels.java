package Arrays;

public class ReverseVowels {
    public static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
       int l = 0;
        int r = arr.length-1;
        while(l < r){
            char ch1 = Character.toLowerCase(arr[l]);
            char ch2 = Character.toLowerCase(arr[r]);
            
            if(valid(ch1) && valid(ch2)){
                char t = arr[l];
                arr[l] = arr[r];
                arr[r] = t;
                l++;
                r--;
            }
            else if(valid(ch1)){
                r--;
            }
            else{
                l++;
            }
            
            
        }
        return new String(arr);
    }
    public static boolean valid(char ch1){
        if(ch1 == 'a' || ch1 == 'e' || ch1 == 'i'|| ch1 =='o' || ch1 == 'u'){
            return true;
        }
        return false;
    }
}
