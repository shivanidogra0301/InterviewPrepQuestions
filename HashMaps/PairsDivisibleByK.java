package HashMaps;

import java.util.HashMap;

public class PairsDivisibleByK {
     /*
        we make a freq count of arr[i]%k
        and check if every remainder have equal pair of complementry remainder
        for eg let say k = 10,
        then for 22 rem = 2, we must have rem = 8 so that they add upto make number divisble by 10, check for every remainer, in case of 0 we should check that they are even
        also same case for 5 i.e k/2
    */
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer,Integer>fmap = new HashMap<>();
        
        for(int i = 0; i < arr.length; i++){
            int rem = arr[i]%k;
            if(rem < 0){
                rem += k;
            }
            fmap.put(rem,fmap.getOrDefault(rem,0)+1);
        }
        for(int val : arr){
            int rem = val % k;
            if(rem < 0){
                rem += k;
            }
            
            if(rem == 0 || rem * 2 == k){
                int freq = fmap.get(rem);
                if(freq % 2 != 0){
                    return false;
                }
            }
            else{
                int freq1 = fmap.get(rem);
                int freq2 = fmap.getOrDefault(k - rem,0);
                if(freq1 != freq2){
                    return false;
                }
            }
        }
        return true;
    }
}
