package Arrays;

import java.util.List;
import java.util.PriorityQueue;

public class SmallestRange {
    class Pair implements Comparable<Pair>{
        int val;
        int r;
        int c;
        Pair(int val,int r, int c){
            this.val = val;
            this.r = r;
            this.c = c;
        }
        public int compareTo(Pair o){
            return this.val - o.val;
        }
        
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.size(); i++){
            pq.add(new Pair(nums.get(i).get(0),i,0));
             max = Math.max(nums.get(i).get(0),max);           
        }
        

        
        int range = Integer.MAX_VALUE;
        int s = 0;
        int e = 0;
        while(true){
            Pair p = pq.remove();
            // System.out.println(p.val+" "+max);
            int crange = max - p.val +1;
            if(crange < range){
                range = crange;
                s = p.val;
                e = max;
            }
            int nr = p.r;
            int ncol = p.c+1;
            if(ncol < nums.get(nr).size()){
                pq.add(new Pair(nums.get(nr).get(ncol),nr,ncol));
                max = Math.max(max,nums.get(nr).get(ncol));
            }
            else{
                break;
            }
            
            
            
        }
        return new int[]{s,e};
        
    }
}
