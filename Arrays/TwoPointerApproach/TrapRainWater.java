package Arrays.TwoPointerApproach;

public class TrapRainWater {
    public int trap(int[] height) {
        if(height.length == 0){
            return 0;
        }
        int i =0; 
        int j = height.length-1;
        int prefixmax = height[i];
        int suffixmax = height[j];
        int water = 0;
        while(i < j){
            if(prefixmax <= suffixmax){
                water +=  prefixmax - height[i];
                i++;
                prefixmax = Math.max(prefixmax,height[i]);
            }
            else{
                water +=  suffixmax - height[j];
                j--;
                suffixmax = Math.max(suffixmax,height[j]);
            }
        }
        return water;
    }
}
