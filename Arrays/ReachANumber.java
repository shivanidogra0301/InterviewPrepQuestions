package Arrays;

public class ReachANumber {
    public int reachNumber(int target) {
        int i = 0;
        int sum = 0;
        if(target < 0){
            target = - target;
        }
        while(true){
            i++;
            sum += i;
            
            if(sum == target || ((sum > target) &&(target - sum)%2 == 0)){
                break;
            }
           
        }
        return i;
        
        
        }
}
