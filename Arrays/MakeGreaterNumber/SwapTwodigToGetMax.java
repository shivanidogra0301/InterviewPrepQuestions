package Arrays.MakeGreaterNumber;

public class SwapTwodigToGetMax {
    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int maxidx = -1;
        int maxdig = -1;
        int leftidx = -1;
        int rightidx = -1;
        
        for(int i = arr.length -1 ; i >= 0; i--){
            if(arr[i] - '0' > maxdig){
                maxdig = arr[i] - '0';
                maxidx = i;
            }
            
            if(arr[i] - '0' < maxdig){
                leftidx = i;
                rightidx = maxidx;
            }
        }
        if(leftidx != -1){
            char temp = arr[leftidx];
            arr[leftidx] = arr[rightidx];
            arr[rightidx] = temp;
        } 
        
        return Integer.parseInt(new String(arr));
    }
}
