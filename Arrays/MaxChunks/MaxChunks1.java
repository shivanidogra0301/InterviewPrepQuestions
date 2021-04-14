package Arrays.MaxChunks;

public class MaxChunks1 {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < arr.length; i++){
            max = Math.max(arr[i], max);
            
            if(i == max){
                ans++;
            }
        }
        
        return ans;
        
    }
}
