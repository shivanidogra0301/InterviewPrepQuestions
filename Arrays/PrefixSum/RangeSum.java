package Arrays.PrefixSum;
public class RangeSum{
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        
        int[] prsum = new int[length];
        
        for(int i = 0; i < updates.length; i++){
            int si = updates[i][0];
            int ei = updates[i][1];
            int val = updates[i][2];
            prsum[si ] += val;
            if(ei+1 < length)
                prsum[ei+1] -= val;   
    
        }
        for(int i = 1; i < length; i++){
            prsum[i] += prsum[i-1] ;
        }
        return prsum;
    }
    
}
