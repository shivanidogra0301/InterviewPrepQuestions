package Arrays.Timings;

import java.util.Arrays;
import java.util.List;

public class MeetingRooms2 {
    
    public class Interval {
        int start, end;
         Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
     }
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        int[] st = new int[intervals.size()];
        int[] et = new int[intervals.size()];
        for(int i = 0; i < intervals.size(); i++){
            st[i] = intervals.get(i).start;
            et[i] = intervals.get(i).end;
        }
        Arrays.sort(st);
        Arrays.sort(et);

        int i = 0;
        int j = 0;
        int omax = 0;
        int curmax = 0;
        while(i < st.length){
            if(st[i] < et[j]){
                curmax++;
                i++;
            }
            else{
                curmax--;
                j++;
            }

            if(curmax > omax){
                omax = curmax;
            }
        }
        return omax;
    }
}
