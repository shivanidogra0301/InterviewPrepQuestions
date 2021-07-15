package Graph.ArticulationPoint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/* articulation point vo point hota h, jisko htane se hmara graoh don disconnected component m tut jata h
or in other words jiss point k niche vali nodes se koi b path uske upr vali node pe ni jata.
yha niche or upr se hmara mtlb h hm jiss path se uss node pe aaye h, unn node ko chodke jo bchi hui nodes
h , vo kbhi b uss path ki node ko touch ni krni chaiye

Algo par[] stores ki hm kis node se travel hoke is node pe aaye h, jese 1->2->3 yha age hm 2 se 3 tk gye t0
                                                                        \_____|
                                                                        par[3] = 2 hoga
    disc[] store krta h kis time pe hm us node pe phoche(kb uski discovery hui)
    low[u] store krta h , u node lowest kis dicovered node ko point kr skti h,lowest se hmara mtlb jiska dicovery
    time sbse km ho. isme vo node ni aaegi jis path se hm 'u' pr phoche h
    ap[] will store true if u is articulation point

    Note : yha pr hmpr node ki id phchan uske discoverable time se hogi na ki uske vtx pe jo value store h

    starting m hr node m uska discovery time rkh denge, time variable ko use krke and kyuki initially
    hr node khud ko hi point krri hogi to lowest m b discovery time aa jaega.

    node hm u pe jake uske nbrs v ko check krenge
    3 cases
    v already visited h, or u ka parent h mtlb hm v se u pr aaye h, or kyuki u k nbrs m b v hoga hi
    to iss case m simply continue

    v visited h, but u ka parent ni h, mtlb hm u pe 'v' se hoke ni aaye h, but still v visited h
    to iss case m hm apne low ko update kr skte h, low[u] = min(low[u],disc[v])
    kyuki v u ka nbr h, to pkka unki bich m edge hogi hi, to hm ye dekhene ki v kb discover hua tha
    agr vo low[u] se chhota hua, to mtlb v ek aise node h, jo uske path m to pkke se ni h, or discovery
    b km h to ek aise node jo na path m h, or discovery km , yehi chij to hm low[u] m store krenge
    example  1->2->3->4 here we go 4 via path 1-2-3-5-4 to 4 ka low m abhi 5 hoga,i.e 5 time pe discover hua ans
                   |_5_|    khud ko point krra h but hm dekh skte h ki isse lowest 3 h, jisk dicovery time 3 h, to
                            yha hme low ko update krna hoga.
    
    third case, when v is unvisited to first recursion call hoga. sbka low, discovery dl jaega
    then backtrack krte hue hm check krenge ki 
    fo source agr uske do children h to vo k articulation point hoga otherwise no
    non source vtx k liye, agr hmare nbr v ka low[v] >= disc[u] means jo v vts h vo lowest
    ya to u ko point kregi ya usse bdi node, i.e u k path vali nodes ko point ni kregi to u ek
    articulation point h.
    also update low[u] as agr low[v] agr chhota h, or hmari direct edge v tk h to hmara low b vhi hoga
    



*/
public class ArticulationPoint {
    static int[] par;
    static int[] low;
    static int[] disc;
    static boolean[] ap;
    static boolean[] vis;
    static int time;
    static int count;

    public static void main(String[] args) throws NumberFormatException,IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String[] st = br.readLine().split(" ");
            int n = Integer.parseInt(st[0]); //vertices
            int m = Integer.parseInt(st[1]); // edges
            if(n == 0 && m == 0){
                return;
            }
            int[][] arr = new int[m][2];
            for(int i = 0; i < m; i++){
                st = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(st[0]);
                arr[i][1] = Integer.parseInt(st[1]);

            }
            System.out.println(solve(n,m,arr));
        }
        
    }
    public static int solve(int n, int m, int[][] arr){
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            int u = arr[i][0];
            int v = arr[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        disc = new int[n+1];
        low = new int[n+1];
        vis = new boolean[n+1];
        time = 0;
        par = new int[n+1];
        ap = new boolean[n+1];
        count = 0;
        articulationpoint(1,graph);
        int ans = 0;

        for(int i = 1; i <= n; i++){
            if(ap[i]){
                ans++;
            }
        }
        return ans;
    }

    public static void articulationpoint(int u,  ArrayList<ArrayList<Integer>> graph){
            disc[u] = low[u] = time;
            time++;
            vis[u] = true;
            for(int v : graph.get(u)){
                if(v == par[u]){
                    continue;
                }
                else if(vis[v] == true){
                    low[u] = Math.min(low[u],disc[v]);
                }

                else{
                    par[v] = u;
                    articulationpoint(v,graph);
                    if(par[u] == 0){
                        count++;
                        if(count >= 2){
                            ap[u] = true;
                        }
                    }
                    else{
                        if(low[v] >= disc[u]){
                            ap[u] = true;
                        }
                    }
                    low[u] = Math.min(low[u],low[v]);
                }
            }
    }
    

}
