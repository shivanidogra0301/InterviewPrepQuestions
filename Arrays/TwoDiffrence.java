package Arrays;

import java.util.Arrays;

public class TwoDiffrence {
    public boolean findPair(int arr[], int size, int target)
    {
        Arrays.sort(arr);
        int i = 0;
        int j = 0;
        
        while(j < arr.length){
            if(arr[j] - arr[i] == target){
                return true;
            }
            else if(arr[j] - arr[i] > target){
                i++;
            }
            else{
                j++;
            }
        }
        return false;
    }
}
