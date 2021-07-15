package HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctInWindow {
    /*
    phle k-1 bnde hashmap m dal denge fr kth dalke check map ka jo size hoga vo uss window ka dis
    element ka count hoga, fr 0 vale ko hta demge and nya bnda dalenge

    */
    ArrayList<Integer> countDistinct(int arr[], int n, int k)
    {
        HashMap<Integer,Integer> map = new HashMap<>();
        // 0 basd indexin m kthbnda k-1 index pe hota h
        // to hm phle k-1 bnde dalenge which is i < k-1
        for(int i =0; i < k-1; i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        // now kth bnda dalte rho or shuru k bnde release krte rho
        int j = 0;
        for(int i = k-1; i < arr.length; i++){
            //aquire
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            
            //work
            ans.add(map.size());
            
            //release
            int freq = map.get(arr[j]);
            if(freq == 1){
                map.remove(arr[j]);
            }
            else{
               map.put(arr[j],map.getOrDefault(arr[j],0)-1); 
            }
            j++;
        }
        return ans;
    }
}
