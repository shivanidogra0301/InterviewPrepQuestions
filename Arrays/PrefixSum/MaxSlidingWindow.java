package Arrays.PrefixSum;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] prefixmax = new int[nums.length];
        int[] suffixmax = new int[nums.length];
       for(int i = 0; i < nums.length; i++){
           if(i%k == 0){
               prefixmax[i] = nums[i];
           }
           else{
               prefixmax[i] = Math.max(prefixmax[i-1],nums[i]);
           }
       }
        
        suffixmax[nums.length-1] = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--){
           if((i+1)%k == 0){
               suffixmax[i] = nums[i];
           }
           else{
               suffixmax[i] = Math.max(suffixmax[i+1],nums[i]);
           }
       }
    int[] ans = new int[nums.length - k + 1];
        
    for(int i = 0; i < ans.length; i++){
       
           ans[i] = Math.max(suffixmax[i],prefixmax[i+k-1]);
       
        
       } 
        
        
        
        return ans;
    }
}
