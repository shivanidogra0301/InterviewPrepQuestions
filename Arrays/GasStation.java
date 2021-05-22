package Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalcost = 0;
        int totalgas = 0;
        int idx = -1;
        int prefix = 0;
        int minprefix = Integer.MAX_VALUE;
        for(int i = 0; i < gas.length; i++){
            totalgas += gas[i];
            totalcost += cost[i];
            prefix += gas[i] - cost[i];
            if(prefix < minprefix){
                minprefix = prefix;
                idx = (i+1)%gas.length;
            }
        }
        if(totalgas < totalcost ){
            return -1;
        }
        else{
            return idx;
        }
    }
}
