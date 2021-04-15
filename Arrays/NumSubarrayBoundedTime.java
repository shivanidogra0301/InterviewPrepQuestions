package Arrays;

public class NumSubarrayBoundedTime {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ans = 0;
        int i = 0;
        int j = 0;
        int prevans = 0;
        while(j < A.length){
            if(A[j] >= L && A[j] <= R){
                ans += j-i+1;
                prevans = j-i+1;
                j++;
            }
            else if(A[j] < L){
                
                ans += prevans;
                j++;
            }
            else if(A[j] > R){
                
                j++;
                i = j;
                prevans = 0;
            }
        }
        
        return ans;
    }
}
