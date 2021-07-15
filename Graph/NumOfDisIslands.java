package Graph;

import java.util.HashSet;

/* jis island ki shape same h usko ek bar hi count krna h, to hm hr call m jake path hashet m dal denge
or count le lenge */
public class NumOfDisIslands {
    static StringBuilder sb;
    public static int numberofDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    sb = new StringBuilder();
                     //not required just a formality   
                    sb.append("X");
                    dfs(grid,i,j);
                    // System.out.println(sb);
                    //unique path vali string add ho jaengi
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    public static void dfs(int[][] grid, int i, int j){
        grid[i][j] = 0;

        if(i-1 >= 0 && grid[i-1][j] == 1 ){
            sb.append("U");
            dfs(grid,i-1,j);
        }

        if(j+1 < grid[0].length && grid[i][j+1] == 1 ){
            sb.append("R");
            dfs(grid,i,j+1);
        }
        if(i+1 < grid.length && grid[i+1][j] == 1 ){
            sb.append("D");
            dfs(grid,i+1,j);
        }
        if(j-1 >= 0 && grid[i][j-1] == 1 ){
            sb.append("L");
            dfs(grid,i,j-1);
        }
        sb.append("Z");
    }
}
