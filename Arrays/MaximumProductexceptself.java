package Arrays;

public class MaximumProductexceptself {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0 ){
                count++;
                continue;
            }
            prod = prod * nums[i];
        }
        
        
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                nums[i] = prod/nums[i];
            }
            else if(count == 1){
                nums[i] = (nums[i] == 0)? prod:0;
            }
            else{
                nums[i] = 0;
            }
        }
        return nums;
    }
}
