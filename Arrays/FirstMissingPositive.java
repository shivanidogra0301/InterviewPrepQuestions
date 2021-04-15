package Arrays;

public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        
        int checkrange = nums.length;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == (i+1)){
                continue;
            }
            if(nums[i] < 1 || nums[i] > checkrange){
                continue;
            }
            
            int si = i;
            int ei = nums[i]-1;
            if(nums[si] == nums[ei]) continue;
            int temp = nums[si];
            nums[si] = nums[ei];
            nums[ei] = temp;
            i--;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != (i+1)){
                return i+1;
            }
        }
        
        return checkrange+1;
    }
}
