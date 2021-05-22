package Arrays.Timings;

import java.util.Collections;
import java.util.List;

public class MeetingRooms {

    public class Interval {
            int start, end;
             Interval(int start, int end) {
                this.start = start;
                this.end = end;
            }
         }
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals,(a,b)->  a.start - b.start);
        for(int i = 0; i < intervals.size() -1; i++ ){
            int e1 = intervals.get(i).end;
            int s2 = intervals.get(i+1).start;
            if(e1 > s2){
                return false;
            }
        }
        return true;
    }
}
