package Arrays.ArrayPartitioning;

public class PartitionArrayIntoDisjoint {
    public int partitionDisjoint(int[] A) {
        int[] maxL = new int[A.length];
        int[] minR = new int[A.length];
        maxL[0] = A[0];
        for(int i = 1; i < A.length; i++){
            if(A[i] > maxL[i-1]){
                maxL[i] = A[i];
            }
            else{
                maxL[i] = maxL[i-1];
            }
        }
        minR[A.length -1] = A[A.length-1];
        for(int i = A.length -2; i >= 0; i--){
            if(A[i] < minR[i+1] ){
                minR[i] = A[i];
            }
            else{
                minR[i] = minR[i+1];
            }
        }
        int ans = 0;
        for(int i = 0; i < A.length-1; i++){
            if(maxL[i] <= minR[i+1]){
                ans = i+1;
                break;
            }
        }
        return ans;
    }
}
