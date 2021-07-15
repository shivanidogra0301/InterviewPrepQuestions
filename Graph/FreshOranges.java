package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class FreshOranges {
    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i =0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        if(fresh == 0){
            return 0;
        }
        int level = -1;
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        
        while(q.size() > 0){
            level++;
            
            int size = q.size();
            while(size-- > 0){
                Pair rem = q.remove();
                for(int i = 0; i < 4; i++){
                    int rdash = rem.row + dir[i][0];
                    int cdash = rem.col + dir[i][1];
                    
                    if(rdash < 0 || cdash < 0 || rdash >= grid.length || cdash >= grid[0].length || grid[rdash][cdash] != 1 ){
                        continue;
                    }
                    q.add(new Pair(rdash,cdash));
                    fresh--;
                    grid[rdash][cdash] = 2;
                    
                }
            }
        }
        if(fresh == 0){
            return level;
        }
        else{
            return -1;
        }
    }
}
