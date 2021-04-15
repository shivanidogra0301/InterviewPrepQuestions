package Arrays;

public class WiggleSort {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++){
            if(i %2 == 0){
                if(nums[i] > nums[i+1]){
                    int t = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = t;
                }
            }
            else{
                if(nums[i] < nums[i+1]){
                    int t = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = t;
                }
            }
        }
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
}
