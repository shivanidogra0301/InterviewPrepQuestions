package Arrays.MaxConsecutive;

public class MaxConsecutive {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int j = 0;
        int i = 0;
        int zerocount = 0;
        int zeroindex = -1;
        int omax = Integer.MIN_VALUE;   
        while(j < nums.length){
            if(nums[j] == 1){
                omax = Math.max(omax,(j-i+1));
            }
            else{
                zerocount++;
                if(zeroindex == -1){
                    zeroindex = j;

                }
                if(zerocount > 1){
                    i = zeroindex+1;
                    zeroindex = j;

                }
                omax = Math.max(omax,(j-i+1));
                
                }
            j++;

            }
            return omax;
        }
}
