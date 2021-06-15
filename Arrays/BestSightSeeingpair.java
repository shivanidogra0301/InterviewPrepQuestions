package Arrays;

public class BestSightSeeingpair {
    public int maxScoreSightseeingPair(int[] a) {
        /* given condition can be break into A[i]+[i] +A[j]-[j] so we fix max(A[i]+[i]) and find corresponding A[j]-[j]*/
        int maxsf = a[0]+0;
        int ans = 0;
        
        for(int i = 1; i < a.length; i++){
            ans = Math.max(ans,maxsf + a[i] - i);
            if(a[i] + i > maxsf){
                maxsf = a[i]+i;
            }
        }
        return ans;
    }
}
