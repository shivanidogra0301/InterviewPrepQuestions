package Arrays.Timings;

import java.util.ArrayList;

public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> ans = new ArrayList<>();
        int i = 0; 
        int gs = newInterval[0];
        int ge = newInterval[1];
        
        while(i < intervals.length){
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(e < gs){
                ans.add(new int[]{s,e});
                i++;
            }
            else{
                break;
            }
        }
        int[] anspair = {Integer.MAX_VALUE,Integer.MIN_VALUE};
        boolean merge = false;
        while(i < intervals.length){
            int s = intervals[i][0];
            int e = intervals[i][1];
            if(s <= ge){
                merge = true;
                
                anspair[0] = Math.min(anspair[0],Math.min(s,gs));
                anspair[1] = Math.max(anspair[1],Math.max(e,ge));
                i++;
            }
            else{
                
                break;
            }
        }
        
        if(merge){
            ans.add(anspair);
            
        }
        else{
            ans.add(newInterval);
        }
        
        
        while(i < intervals.length){
            ans.add(intervals[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][2]);
        
    }
}
