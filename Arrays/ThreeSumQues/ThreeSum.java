package Arrays.ThreeSumQues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        // we want a+b+c so every ith position we make it a, then check for two sum (b+c)
     //to remove same triplets just skip the same values in ith ans also in lo, hi position
         
         int i = 0;
         Arrays.sort(nums);
         
         List<List<Integer>> ans = new ArrayList<>();
         while(i < nums.length-2){
             if(i > 0 && nums[i-1] == nums[i]){
                 i++;
                 continue;
             }
             if(nums[i] > 0){
                 break;
             }
             int target = 0 - nums[i];
             int lo = i+1;
             int hi = nums.length-1;
             while(lo < hi){
                 if(nums[lo] + nums[hi] == target){
                     ans.add(Arrays.asList(nums[i],nums[lo],nums[hi]));
                     while(lo < hi && nums[lo+1] == nums[lo]) { lo++;}
                      while(lo < hi && nums[hi-1] == nums[hi]) { hi--;}
                     lo++;
                     hi--;
                 }
                 else if(nums[lo] + nums[hi] > target){hi--;}
                 else{lo++;}
             }
             i++;
         }
         return ans;
     }
}
