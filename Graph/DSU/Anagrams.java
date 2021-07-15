package Graph.DSU;

public class Anagrams {
/* isme hme total group btane h, vo groups jinme strings k char ko  ek swap krne se hi vo equal bn jae
mtlb uske index m jo char h vo dono string m bss 2 tk ka diffence ho mtlb
do string compare krti tars rats m bss do hi index h jahan values same ni h

*/
    int count;
    int[] par;
    int[] rank;
    public int numSimilarGroups(String[] strs) {
         count = strs.length;
        par = new int[strs.length];
        rank = new int[strs.length];
        for(int i = 0; i < par.length; i++){
            par[i] = i;
            rank[i] =1;
        }
        for(int i = 0; i < strs.length; i++){
            for(int j = 1; j < strs.length; j++){
                String word1 = strs[i];
                String word2 = strs[j];
                int diff = 0;
                for(int k = 0; k < word1.length();k++){
                    if(word1.charAt(k)!= word2.charAt(k)){
                        diff++;
                    }
                }
                if(diff <= 2){
                    union(i,j);
                }
            }
        }
        return count;
    }
    
    
    public  int find(int x){
        if(par[x] == x){
            return x;
        }
        int temp = find(par[x]);
        par[x] = temp;
        return temp;
    }
    
    public  void union(int x, int y){
        int lx = find(x);
        int ly = find(y);
        if(lx != ly){
            count--;
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
        }
    }
}
