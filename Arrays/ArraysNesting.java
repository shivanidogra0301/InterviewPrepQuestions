package Arrays;

public class ArraysNesting {
      /* the candidates which gives the ans like in this case 0,5,6,2 will give the ans 4
    even we start from any of these indexes, so if we found the ans we marked the position
    to remove urepeated calls*/
    public int arrayNesting(int[] nums) {
        int ans = 1;
        for(int i = 0; i < nums.length; i++){
            int j = i;
            int count = 0;
            while(nums[j]>= 0){
                count++;
                int temp = nums[j];
                nums[j] = -1;
                j = temp;
                
            }
            ans = Math.max(ans,count);
        }
        return ans;
    }
}
