package Graph;
/* vo 1 jha se  1 pe travel krte hue agr boundary pe chle jaye to unko htana h, or bche hue 1 ginne h
to hm dfs lgake un 1s ko hta denge then bche 1 gin lenge */
public class numOfenclaves {
    public int numEnclaves(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
            // vo 1s jo ya boundary pe h ya fr boundary se connected h un sbko hta denge
            if(i == 0 || j == 0 || i == grid.length -1 ||j == grid[0].length-1){
                    if(grid[i][j] == 1)
                        dfs(grid,i,j);
                }
            }
        }
        int ans = 0;
        //remaining count kr lenge
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;
    }
    
    
     public static void dfs(int[][] grid, int i, int j){
        grid[i][j] = 0;

        if(i-1 >= 0 && grid[i-1][j] == 1 ){
            dfs(grid,i-1,j);
        }

        if(j+1 < grid[0].length && grid[i][j+1] == 1 ){
            dfs(grid,i,j+1);
        }
        if(i+1 < grid.length && grid[i+1][j] == 1 ){
            dfs(grid,i+1,j);
        }
        if(j-1 >= 0 && grid[i][j-1] == 1 ){
            dfs(grid,i,j-1);
        }
    }
}
