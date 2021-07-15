package Graph;

import java.util.Arrays;

public class MinSwapToMakeSort {
    class Pair implements Comparable<Pair>{
        int val;
        int idx;
        
        Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
        public int compareTo(Pair o){
            return this.val - o.val;
        }
    }
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {   Pair[] arr = new Pair[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = new Pair(nums[i],i);
        }
        Arrays.sort(arr);
        int ans = 0;
        boolean[] vis = new boolean[arr.length];
        for(int i = 0; i < arr.length; i++){
            if(arr[i].idx == i){
                continue;
            }
            
            int j = i;
            int cycles = 0;
            while(!vis[j]){
                cycles++;
                vis[j] = true;
                
                j = arr[j].idx;
            }
            if(cycles > 0)
                ans += cycles-1;
        }
        return ans;
    }
}
