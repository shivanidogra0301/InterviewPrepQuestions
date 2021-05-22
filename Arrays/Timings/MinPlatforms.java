package Arrays.Timings;

import java.util.Arrays;

public class MinPlatforms {
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0;
        int j = 0;
        int cur = 0;
        int omax= 0;
        while(i < arr.length){
            if(arr[i] <= dep[j]){
                cur++;
                i++;
            }else{
                cur--;
                j++;
            }
            
            if(cur > omax){
                omax = cur;
            }
        }
        return omax;
        
    }
}
