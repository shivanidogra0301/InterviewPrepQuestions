package Graph.StronglyConnected;

public class BorderColoring {
    /*
    is ques m hme r,c given uspe jo color let say 2 h, to hme uske sare connected components
    jo border pe h unka color given color lets say 3 se replace krna h. grid m change krke

    // definition of connected components ki components uske adjacent ho ir top,left, bottom,down
    ans uska color b same ho ie. 2 to vo ek connected element mana jaega

    ab unn connected components m se hme vhi print krne h jo border pe ho mtln jiski atleast ek side
    aisi ho jo 2 color ki na ho or jo ya fr jo first and last row,color vo b same hi mane jaenge
    kyuki unki ek side ki info hogi hi nhi.

    to hm recursivly hr adjacent component pe jaenge or usse charo trf kitne 2 present h uska count le lenge
    then post order m jb 4 calls lg jaengi agr uska count 4 hua to hm grid ko update nhi krenge
    */

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        dfs(grid,r0,c0,grid[r0][c0],color,vis);
        return grid;
    }
    
    public static void dfs(int[][] grid, int r, int c,int curcolor,int color,boolean[][]vis){
        vis[r][c] = true;
        
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};
        int count = 0;
        for(int i =0; i < 4; i++){
            int nr = r + dir[i][0];
            int nc = c+dir[i][1];
            // check range m h ya ni
            if(nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length ){
                continue;
            }
            /* agr visited to call ni lgegi vrna infinite call lg jaengi but true h to ye ek valid
            component h to simple count krlo*/
            if(vis[nr][nc] == true){
                count++;
            }
            else{
                //ni to check kro and aage ki ans b calculate kro
                if(grid[nr][nc] == curcolor){
                    count++;
                    dfs(grid,nr,nc,curcolor,color,vis);
                }
                
                    
            }
        }
        if(count != 4){
            grid[r][c] = color;
        }
    }
    
}
