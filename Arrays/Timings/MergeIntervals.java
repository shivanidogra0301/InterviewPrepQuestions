package Arrays.Timings;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    class Pair{
        int s; 
        int e;
        Pair(int s, int e){
            this.s = s; 
            this.e = e;
        }
    }
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        LinkedList<Pair> list = new LinkedList<>();
        list.add(new Pair(intervals[0][0],intervals[0][1]));
        for(int i =1; i < intervals.length; i++){
            int s = intervals[i][0];
            int e = intervals[i][1];
            Pair rp = list.removeFirst();
            if( s <= rp.e ){
                list.addFirst(new Pair(rp.s,Math.max(e,rp.e)));
            
            }
            else{
                list.addFirst(rp);
                list.addFirst(new Pair(s,e));
            }
            
            
        }
        int[][] ans = new int[list.size()][2];
        for(int i = 0; i < ans.length; i++){
            Pair rp = list.removeFirst();
            ans[i][0] = rp.s;
            ans[i][1] = rp.e;
        }
        return ans;
    }
}
