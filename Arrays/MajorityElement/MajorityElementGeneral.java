package Arrays.MajorityElement;

import java.util.HashMap;
import java.util.HashSet;

public class MajorityElementGeneral {
    public int countOccurence(int[] arr, int n, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i],1);
            }
            if(map.get(arr[i]) > n/k){
                set.add(arr[i]);
            }
        }
        return set.size();
        
        
    }
}
