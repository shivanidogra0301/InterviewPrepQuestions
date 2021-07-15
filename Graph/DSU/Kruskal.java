package Graph.DSU;
import java.util.*;
public class Kruskal {
    

	static class Pair implements Comparable<Pair>{
		int u;
		int v;
		int wt;
		Pair(int u, int v, int wt){
			this.u = u;
			this.v = v;
			this.wt = wt;
		}
		public int compareTo(Pair o){
			return this.wt - o.wt;
		}
	}
	static int[] par;
    static int[] rank;

	public static void main (String[] args) throws java.lang.Exception
	{	Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int edges = scn.nextInt();
		Pair[] arr = new Pair[edges];
		for(int i = 0; i < edges; i++){
			int u = scn.nextInt();
			int ve = scn.nextInt();
			int wt = scn.nextInt();
			
			arr[i] = new Pair(u,ve,wt);
		}
		Arrays.sort(arr);
		par  = new int[v+1];
        rank = new int[v+1];
        for(int i = 1; i < v+1; i++){
            par[i] = i;
            rank[i] = 1;
        }
		long ans = 0;
		for(int i = 0; i < edges; i++){
			boolean flag = union(arr[i].u,arr[i].v);
			if(flag == true){
				continue;
			}
			ans+=(long) arr[i].wt;		
			
		}
		System.out.println(ans);
	}
	
	public static int find(int x){
        if(par[x] == x){
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }
    
    public static boolean union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        
        if(lx != ly){
             if(rank[lx] > rank[ly]){
                par[ly] = lx;
            }
            else if(rank[ly] > rank[lx]){
                par[lx] = ly;
            }
            else{
                par[lx] = ly;
                rank[ly]++;
            }
            return false;
        }
        else{
        	return true;
        }
    }
}

