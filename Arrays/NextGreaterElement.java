package Arrays;
public class NextGreaterElement {
    public int nextGreaterElement(int n) {
        char[] arr = ("" + n).toCharArray();
        int len = arr.length;
        int place = -1;
        for(int i = len-2; i >= 0; i--){
            if(arr[i] < arr[i+1]){
                place = i;
                break;
            }
        }
        if(place == -1){
            return -1;
        }
        
        char ch = arr[place];
        int rch = place+1;
        // System.out.println(place);
        for(int i = place+1; i < len; i++){
            if(arr[i] > ch && arr[i] <= arr[rch]){
                rch = i;
            }
        }
        
        char temp = arr[rch];
        arr[rch] = arr[place];
        arr[place] = temp;
        
        
        int left = place+1;
        int right = len-1;
        while(left < right){
            char t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
            left++;
            right--;
        }
        
        long ans = Long.parseLong(new String(arr)) ;
        if(ans > Integer.MAX_VALUE) 
            return -1;
        else
            return (int)ans;
            
    }
}
