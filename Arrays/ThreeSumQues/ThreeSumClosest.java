package Arrays.ThreeSumQues;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
            
            if(diff == 0){
                break;
            }
            int lo = i+1;
            int hi = nums.length-1;
            while(lo < hi){
                int sum = nums[i] + nums[lo] + nums[hi];
                if(Math.abs(target - sum) < Math.abs(diff)){
                    diff = target - sum;
                }
                
                if(sum < target){
                    lo++;
                }
                else{
                    hi--;
                }
            }
        }
        return target - diff;
    }
}
