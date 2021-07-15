package Graph;

import java.util.PriorityQueue;

public class MaxElevationswim {
      /* hm hr node se hr rsta dekhnege and node and us nbr k max ko store rkhenge
    vhi common elevation hoga, and pq use krenge to get minimum ans. 
    optimisation ki agr ek node visited h to mtlb us node tk phle jo b rsta gya tha vo 
    smaller tha, to cur rste m us node ko add krne ka mtlb ni h 
    basically dijsktra implement krna h pr yha hme edwt ko sum nhi krna 
    unka max lena h*/
    class Pair implements Comparable<Pair>{
        int row;
        int col;
        int msf;
        
        Pair(int i, int j, int msf){
            this.row = i;
            this.col = j;
            this.msf = msf;
        }
        public int compareTo(Pair o){
            return this.msf - o.msf;
        }
            
    }
    public int swimInWater(int[][] grid) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,grid[0][0]));
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        while(pq.size() > 0){
            Pair rem = pq.remove();
            if(rem.row == grid.length-1 && rem.col == grid[0].length-1){
                return rem.msf;
            }
            
            if(vis[rem.row][rem.col] == true){
                continue;
            }
            vis[rem.row][rem.col] = true;
            for(int i = 0; i < 4; i++){
                int nr = rem.row + dirs[i][0];
                int nc = rem.col + dirs[i][1];
                
                if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length || vis[nr][nc] == true){
                    continue;
                }
                
                pq.add(new Pair(nr,nc,Math.max(rem.msf,grid[nr][nc])));
            }
        }
        //not required cause loop se value pkka jaegi
        return 0;
    }
}
