package Graph;

import java.util.Arrays;
/*
hme shortest path nikalna h in terms of edge wt but extra condition given h ki no of stops
should b k, to dijkstra is not valid in this case. So basically, agr hme stops vala path nikalna h
that mean hme k+1 length ka path nikalna h btw src and des
so we will use bellman ford, but if we use same array, then bellmanford on kth iteration gives path
of length of atleast k, yani usse zyada length vala path ki value b dli ho skti h,
kyuki manlo hmne ek node ko kth iteration m update kr dia, agr use node koi or edge h, to jb use edge
ko process krenge to vo updated value lega, jisse and m bdi path length b aaskti h,
to remove that hm do array bnaenge
now prev[u]+wt < cur[v]
 isme cur isliye likha kyuki same path length k do ans ho skte h, hme vo chaiye jo sbse
 chhota ho, hm cur se hi compare krenge.
*/
public class CheapestPathwithKstops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] prev = new int[n];
        Arrays.fill(prev,Integer.MAX_VALUE);
        prev[src] = 0;
        int pathlength = k+1;
        for(int p = 1; p <= pathlength; p++){
            int[] cur = new int[n];
            for(int i = 0; i < n; i++){
                cur[i] = prev[i];
            }
            for(int i = 0; i < flights.length; i++){
                int u = flights[i][0];
                int v = flights[i][1];
                int wt = flights[i][2];
                if(prev[u] == Integer.MAX_VALUE){
                    continue;
                }
                if(prev[u]+wt < cur[v]){
                    cur[v] = prev[u]+wt;
                }
            }
            prev = cur;
        }
        if(prev[dst] == Integer.MAX_VALUE){
            return -1;
        }
        return prev[dst];
    }
}
