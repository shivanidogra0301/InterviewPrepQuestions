package Graph.DSU;

import java.util.Arrays;
/* max deadline ka array bnaenge and  array ko profit k descending order m sort krenge then
hmesha deadline vale aaray ko right se bhrege i.i jiski deadline 4, usko sbse phle 4 pr store rne ki koshish
lrenge then left m jo khali oga vha store kr denge*/
public class JobSequencing {
    class Pair implements Comparable<Pair>{
        int id;
        int d;
        int p;
        Pair(int id, int d, int p){
            this.id = id;
            this.d = d;
            this.p = p;
        }
        
        public int compareTo(Pair o){
            return o.p- this.p;
        }
    }
    int[] par;
    int[] JobScheduling(int arr[][], int n)
    {   
        Pair[] jobs = new Pair[n];
        int maxd = -1;
        for(int i = 0; i < arr.length; i++){
            jobs[i] = new Pair(arr[i][0],arr[i][1],arr[i][2]);
            if(arr[i][1] > maxd){
                maxd = arr[i][1];
            }
        }
        Arrays.sort(jobs);
        int[] ans = new int[2];
        par = new int[maxd+1];
        int count = 0;
        int profit = 0;
        for(int i = 1; i <par.length; i++){
            par[i] = i;
        }
        for(int i = 0; i < jobs.length; i++){
            int idx = find(jobs[i].d);
            if(idx > 0){
                profit += jobs[i].p;
                count++;
                par[idx] = find(idx-1);
            }
            
            
        }
        ans[0] = count;
        ans[1] = profit;
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
}
