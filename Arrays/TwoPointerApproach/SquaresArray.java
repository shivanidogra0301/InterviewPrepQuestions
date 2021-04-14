package Arrays.TwoPointerApproach;

public class SquaresArray {
    public int[] sortedSquares(int[] nums) {
        int[] ans  = new int[nums.length];
        int l = 0;
        int r = nums.length-1;
        int k = nums.length-1;
        
        while(l <= r){
            int sq1 = nums[l] * nums[l];
            int sq2 = nums[r] * nums[r];
            
            if(sq1 > sq2){
                ans[k] = sq1;
                l++;
                k--;
            }
            else if(sq1 < sq2){
                ans[k] = sq2;
                r--;
                k--;
            }
            else{
                
                ans[k] = sq1;
                
                if(l != r){
                    ans[k-1] = sq2;
                    k=k-2;
                }
                else{
                    k--;
                }
                l++;
                r--;
            }
        }
        return ans;
    }
}
