package Graph.DSU;

/* In this question, hme given h ki first row ki sari bricks stable h, or vo brick jo directly ya indirectly
first row se connected h, vo b stable h, agr hm kuch bricks hits[][] ko hta de, to unki vjah se
kitni bricks unstable ho jaegi vo count krna h.

So , hm phle vo bricks jinko htana h use 2 mark kr denge, ki hmne use hta dia to agr vo bricks
present ni then bchi hui bricks ka set bna denge union nikalke adjacent bricks for every i an j
plus hm ek dummy node rkhenge 0 , or uss set m kevel vhi nodes aaengi jo directly ya indirecylt
first row k nodes se connected h.

Flow of program, hmne hit ki hui bricks ko htake set bnaye , or vo nodes jo unn brick ko htake b
stable h unka ek set bnaya, baki disconnected nodes k alg alge set bn gye.
ab hm reverse m hit bricks ko traverse krege
Why reverse? kyuki  abhi jo hmara graph bna h, vo ye represent krta h agr sari hitted nodes ko
hta dia to kitni nodes h jo still stable h, jo hme size[0] se mil jaega, ab last vali node ka poora
connected component ka size le lenge or union krne k baad check krenge ki ab size[0] m kitna increase
hua, size[0] m tbhi increase hoga agr jo hitted node h vo direcly 0 set se connected h, or ya fir
indirectly. to uski vjah se jo extra node uss graph m aayi vo vhi nodes hongi jiski stabilty
uss hitted node pe depend krti h, or hme yhi nikalna h.

isse vo nodes jo hitted node k set m h, but uske na hone pe b stable h, vo phle se size[0] m compute
ho chuki hongi, to vo ab count ni hogi.

reverse se isliye kia, kyuki jb let say do queries h [1,0],[1,1] to jb 1,0 ko process krenge, hme graph
vo sari nodes b chaiye jo [1,1] ko 2 mark krne ki vjah se disconnected ho gyi h, tbhi hm [1,0] k liye shi
ans nikal paenge, yani query[1] ka ans tb aaega jb query[2] ki nodes dl chuki hongi isliye hm reverse
m kaam krenge.

*/
public class HittingBricks {

    int[] par;
    int[] size;
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int tr = grid.length;
        int tc = grid[0].length;
        int cells = tr * tc + 1;
        par = new int[cells];
        size = new int[cells];
        
        for(int i = 0; i < cells; i++){
            par[i] = i;
            size[i] = 1;
        }
        //marked hitted nodes
        for(int i = 0; i < hits.length; i++){
            int r = hits[i][0];
            int c = hits[i][1];
            if(grid[r][c] == 1){
                grid[r][c] = 2;
            }
        }
        
        int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
        //traverse matrix, find union of remainining nodes
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int cellno = i * tc + j + 1;
                    // if row 1 h, to vo 0 dummy node se connect hongi
                    if(i == 0){
                        union(0,cellno);
                    }
                    //adjacent cells ka union krlia
                    for(int[] dir : dirs){
                        int nx = i + dir[0]; 
                        int ny = j + dir[1];
                    
                        if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length||grid[nx][ny]  != 1){
                            continue;
                        }
                        
                        int ncellno = nx * tc + ny + 1;                        
                        union(cellno,ncellno);
                    }
                }
            }
        }

        // this point 1 set vo hoga jo phli row m ya to present hoga, ya indirectly connected hoga
        //or baki kuch disconnected set bn jaenge jo kisi b trike se row1 se connect ni h yani unstable h
        //stable nodes count

        int prev = size[0];
        int[] ans = new int[hits.length];
        for(int i = hits.length-1; i >= 0; i--){
            int r = hits[i][0];
            int c = hits[i][1];
            int cellno = r * tc + c + 1;
            if(grid[r][c] != 2){
                continue;
            }
            //add hitted nodes marked 2 only to its adjacent nodes 
             for(int[] dir : dirs){
                    int nx = r + dir[0]; 
                    int ny = c + dir[1];
                    
                    if(nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length || grid[nx][ny]  != 1){
                            continue;
                    }
                    int ncellno = nx * tc + ny + 1;
                    // System.out.println(cellno+" "+ncellno);
                    
                    union(cellno,ncellno);
            }
            //unmarked it
            grid[r][c] = 1;
            
            // if cellno is present in row 1 to 0 k set m dal denge usko
            if( r == 0){
                // System.out.println(0+" "+cellno);
                union(0,cellno);
            }

/*in this region there are three case 
cellno is directly connected to row 1= to ab usko connect krne cellno k adjacent cells b 0 m aa jaege, size[0]inc
cellno is indirectly connected to row 1= mtlb uski adjacent ki koi node row1 se connect h, again size[0]incr
not connected at all prev or cur remain same
            */
            int cur = size[0];
            // -1 kyuki jo node hit hui h usko count ni krna
            ans[i] = cur - prev - 1;

            //if cur == prev, then hmara ans -ve aa jaega to handle this
            if(ans[i] < 0){
                ans[i] = 0;
            }
            //query 2 solve krte hue, nya size[0] consider hoga
            prev = cur;
        }
        
        return ans;
        
    }
    
    public int find(int x){
        if(par[x] == x){
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }
    
    public void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly){
            if(lx == 0){
                par[ly] = 0;
                size[lx] += size[ly];
            }
            else if(ly == 0){
                par[lx] = 0;
                size[ly] += size[lx];
                
            }
            else{
               if(size[lx] > size[ly]){
                    par[ly] = lx;
                    size[lx] += size[ly];
                }
            else{
                par[lx] = ly;
                size[ly] += size[lx];
                } 
            }
            
        }
    }
}
