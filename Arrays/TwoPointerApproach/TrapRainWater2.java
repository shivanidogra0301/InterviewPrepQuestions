package Arrays.TwoPointerApproach;

import java.util.PriorityQueue;

public class TrapRainWater2 {
    class Pair implements Comparable<Pair>{
        int val;
        int r;
        int c;
        Pair(int val, int r, int c){
            this.val = val;
            this.r = r;
            this.c = c;
        }
        public int compareTo(Pair o){
            return this.val - o.val;
        }
        
    }
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[][] vis =new boolean[heightMap.length][heightMap[0].length];
        
        for(int i = 0; i < heightMap.length; i++){
            if(i == 0 || i == heightMap.length-1){
                for(int j = 0; j < heightMap[0].length ; j++){
                    pq.add(new Pair(heightMap[i][j],i,j));
                    vis[i][j] = true;
                }
            }
            else{
                pq.add(new Pair(heightMap[i][0],i,0));
                vis[i][0] = true;
    pq.add(new Pair(heightMap[i][heightMap[0].length - 1],i,heightMap[0].length - 1));
                vis[i][heightMap[0].length - 1] = true;
                
            }
            
        }
        // System.out.println(pq.remove().val);
        int[][]  dirs={{-1,0},{1,0},{0,-1},{0,1}}; 
        int ans = 0;
        while(pq.size() > 0){
            Pair rp = pq.remove();
            
            for(int[] dir : dirs){
                int nr = dir[0] + rp.r;
                int nc = dir[1] +rp.c;
                if(nr < 0 || nc < 0 || nr >= heightMap.length || nc >=                                              heightMap[0].length ||vis[nr][nc] == true){
                        continue;
                }
                if(heightMap[nr][nc] >= rp.val){
                    pq.add(new Pair(heightMap[nr][nc],nr,nc));
                    vis[nr][nc] = true;
                }
                else{
                    ans += rp.val - heightMap[nr][nc];
                    pq.add(new Pair(rp.val,nr,nc));
                    vis[nr][nc] = true;
                    
                }
            }
        }
        return ans;
    }
}
