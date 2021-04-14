package Arrays.MajorityElement;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int val1 = nums[0];
        int count1 = 1;
        int val2 = nums[0];
        int count2 = 0;
        
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != val1 && nums[i] != val2){
                if(count1 == 0){
                    val1 = nums[i];
                    count1++;
                }
                else if(count2 == 0){
                    val2 = nums[i];
                    count2++;
                }
                else{
                    count1--;
                    count2--;
                }
            }
            else{
                if(nums[i] == val1){
                    count1++;
                }
                else {
                    count2++;
                }
            }
        }
        int freq1 = 0;
        int freq2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == val1){
                freq1++;
            }
            if(nums[i] == val2){
                freq2++;
            }
        }
        if(freq1  > nums.length/3){
            ans.add(val1);
        }
        if(val1!= val2 && freq2 > nums.length/3){
            ans.add(val2);
        }
        return ans;
        
    }
}
