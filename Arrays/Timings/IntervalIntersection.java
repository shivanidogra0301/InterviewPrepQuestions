package Arrays.Timings;

import java.util.ArrayList;

public class IntervalIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        ArrayList<int[]> ans = new ArrayList<>();
        while(i < firstList.length && j < secondList.length){
            int s1 = firstList[i][0];
            int e1 = firstList[i][1];
            int s2 = secondList[j][0];
            int e2 = secondList[j][1];
            if(s1 <= e2 && s2 <= e1){
                ans.add(new int[]{Math.max(s1,s2),Math.min(e1,e2)});
            } 
            if(e1 <= e2){
                i++;
                
            }
            else{
                j++;
                
            }
            
        }
        int[][] arr = new int[ans.size()][2];
        for( i = 0; i < ans.size(); i++){
            arr[i][0] = ans.get(i)[0];
            arr[i][1] = ans.get(i)[1];
        }
        return arr;
    }
}
