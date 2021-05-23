package Arrays.ThreeSumQues;

import java.util.Arrays;

public class ThreeSumSmaller {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++){
            int sum = target - nums[i];
            int lo = i+1;
            int hi = nums.length - 1;
            while(lo < hi){
// if nums[lo] (smallest) + nums[hi](largest) < target then all pairs with nums[lo] as one term will give smaller sum , so count those ans inc lo++   
                if(nums[lo]+nums[hi] < sum){
                    count+= hi - lo;
                    lo++;
                }
                else{
                    hi--;
                }
                
            }
        }
        return count;
    }
}
