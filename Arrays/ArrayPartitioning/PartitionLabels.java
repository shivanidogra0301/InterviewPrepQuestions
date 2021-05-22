package Arrays.ArrayPartitioning;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[26];
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            arr[c - 'a'] = i;
        }
        int max = 0;
        int j = 0;
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            max = Math.max(max, arr[ch - 'a']);
            
            if(max == i){
                ans.add((i - j + 1));
                j = i + 1;
            }
            
        }
        return ans;
    }
}
