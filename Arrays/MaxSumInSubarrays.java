package Arrays;

public class MaxSumInSubarrays {
    public static long pairWithMaxSum(long arr[], long N)
    {   long omax = 0;
        for(int i = 0; i < arr.length - 1; i++){
            long sum = arr[i] + arr[i+1];
            omax = Math.max(sum,omax);
        }
        return omax;
    }
}
