package Arrays;

import java.util.Arrays;

public class CarFleet{
    class Pair{
        int p;
        int s;
        Pair(int p, int s){
            this.p = p;
            this.s = s;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length == 0){
            return 0;
        }
        Pair[] arr = new Pair[position.length];
        for(int i = 0; i < position.length; i++){
            arr[i] = new Pair(position[i],speed[i]);
        }
        Arrays.sort(arr,(a,b) -> a.p - b.p);
        int c = 1;
        double t = (target - arr[arr.length-1].p)*1.0/arr[arr.length-1].s;
        
        for(int i = arr.length -2; i >= 0; i--){
            double ct = (target - arr[i].p)*1.0/arr[i].s;
            if(ct > t){
                c++;
                t = ct;
            }
        }
        return c;
    }
}