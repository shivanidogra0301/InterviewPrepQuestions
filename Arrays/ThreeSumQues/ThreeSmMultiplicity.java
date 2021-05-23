package Arrays.ThreeSumQues;

import java.util.Arrays;
public class ThreeSmMultiplicity {
    static int MOD = 1_000_000_007; 
    
    public int threeSumMulti(int[] arr, int target) {
        Arrays.sort(arr);
        
        long tupleCount = 0;
        
        
        for(int i = 0; i < arr.length; i++){
            tupleCount += getCountPairsTwoSum(arr, i + 1, target - arr[i]);
            tupleCount %= MOD;
        }
        
        return (int) tupleCount;
    }
    
    private int getCountPairsTwoSum(int[] arr, int startIndex, int target){
        int l = startIndex;
        int r = arr.length - 1;
        
        long pairsCount = 0;
        
        while(l < r){
            
            
            if(arr[l] + arr[r] < target){
                l++;
            }else if(arr[l] + arr[r] > target){
                r--;
            }else if(arr[l] != arr[r]){
            
                int left = 1;
                while(l + 1 < r && arr[l] == arr[l + 1]){
                    left++;
                    l++;
                }
                
                int right = 1;
                while(r - 1 > l && arr[r] == arr[r - 1]){
                    right++;
                    r--;
                }
                
                pairsCount += (left * right);
                pairsCount %= MOD;
                
                l++;
                r--;
                
            }else if(arr[l] == arr[r]){
                
                int numCount = r - l + 1;
                pairsCount += numCount * (numCount - 1) / 2; 
                
                pairsCount %= MOD;
                
                break;
            }
            
            
        }
        
        return (int)pairsCount;
    }
}
