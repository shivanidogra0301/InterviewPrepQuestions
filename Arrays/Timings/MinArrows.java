package Arrays.Timings;

import java.util.Arrays;

public class MinArrows {
    public int findMinArrowShots(int[][] points) {
        
        Arrays.sort(points, (a,b) ->  a[1] - b[1]  );
        int ans = 1;
        int ps = points[0][0];
        int pe = points[0][1];
        for(int i = 1; i < points.length; i++){
            int cs = points[i][0];
            int ce = points[i][1];
            // System.out.println(cs);
            if(ps <= ce && cs <= pe){
                continue;
            }
            
                ans++;
                ps = cs;
                pe = ce;
            
        }
        return ans;
        
    }
}
