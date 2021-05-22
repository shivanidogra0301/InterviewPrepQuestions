package Arrays.MinimumDistance;

import java.util.ArrayList;

public class BestMeetingPoint {
    public static int minTotalDistance(int[][] grid) {
        // Write your code here
        ArrayList<Integer> x  = new ArrayList<>();
        ArrayList<Integer> y = new ArrayList<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    y.add(i);
                }
            }
        }
        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[j][i] == 1){
                    x.add(i);
                }
            }
        }

        int ix = x.get(x.size()/2);
        int iy = y.get(y.size()/2);
        int dist = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dist += Math.abs((j-ix)) + Math.abs((i - iy));
                }
            }
        }
        
        return dist;
    }
}

