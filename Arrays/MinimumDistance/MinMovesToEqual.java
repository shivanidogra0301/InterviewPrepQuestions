package Arrays.MinimumDistance;

import java.util.Arrays;

public class MinMovesToEqual {
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length/2];
        // System.out.println(mid);
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++){
            ans+= Math.abs(nums[i] - mid);
        }
        return ans;
        
    }
}
