package Arrays;

import java.util.Arrays;

public class SumOfSubsequenceWidth {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long c = 1, res = 0, mod = (long)1e9 + 7;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            res = (res + (nums[i] * c) - (nums[n - i-1] * c))%mod;
            c = (c* 2)%mod;
        }
          return (int)((res+mod)%mod);
    }
}
