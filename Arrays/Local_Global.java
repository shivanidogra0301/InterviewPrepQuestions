package Arrays;

public class Local_Global {
     /*All local inversions are global inversions.
If the number of global inversions is equal to the number of local inversions,
it means that all global inversions in permutations are local inversions.
It also means that we can not find A[i] > A[j] with i+2<=j.
In other words, max(A[i]) < A[i+2]

In this first solution, I traverse A and keep the current biggest number cmax.
cmax isliye kyuki left side ko bda krna
Then I check the condition cmax < A[i+2]*/
public boolean isIdealPermutation(int[] nums) {
    int cmax = Integer.MIN_VALUE;
     for(int i = 0; i < nums.length-2; i++){
         cmax = Math.max(cmax,nums[i]);
         if(cmax > nums[i+2]){
             return false;
         }
     }
     return true;
 }
}
