package HashMaps;

import java.util.HashMap;

public class LargestSubarrayWith0sum {
    /* hum ek hashmap bnaenge sum vs index ka jisme store hoga 
    (sum , i ) means i th index tk sum so far kya tha
    ab agr same sum dobara aaya aage jake mtlb i k bad ki sari values ka sum
    0 hua, e.g = 1,2,-1,-1,3 = prefix sum = 1,3,2,1,4 ab yha 1 repeat
    ho gya mtlb 0th index k bad se jaha tk 1 aaya vha ki values
    ka sum -ve h, aise krke max len nikal lenge
    base case hm map m 0,-1 dalnege ki -1th index tk sum 0 tha
    kyuki agr shuru k element ka sum 0 hua vo isse handle ho jaega
    e.g -2,2 = -2,0 ,map m 0 prenst h for -1th index ans = 1thidx - (-1th)idx
    = 2 which is the ans*/
    
    int maxLen(int arr[], int n)
    {
       HashMap<Integer,Integer> map = new HashMap<>();
       //sum is 0 at idx -1;
       map.put(0,-1);
       int sum = 0;
       int maxlen = 0;
       for(int i = 0; i < arr.length; i++){
           sum += arr[i];
           if(map.containsKey(sum) == false){
               map.put(sum,i);
           }
           else{
               int len = i - map.get(sum);
               maxlen = Math.max(maxlen,len);
           }
       }
       return maxlen;
    }

    /* logic same as find max len but yha hm map m jb count krne ho to map m frequency dlti h
    sum vs freq rkhenge kyuki lets say prefix sum kuch aisa
    h 1(0),2(1),3(2),1(3),5(4),1(5) to yha jb 1 aaya dusri bari
    to sum from idx1 to idx 3
    must be zero tbhi to 1 dobara aagya, to subaraay ka count 1 hogya or
    1 ki freq 2 hogyi ab jb 5th index pe frse 1 aaya that means
    ki 1-5 tk k subarray ka sum b 0 h and 4-5 tk k sub array ka sum b 0 h
    tbhi 1 repeat hua, isliye ab count m +2 hoga to hm freq ka count rkhenge
    jb repeat hua to count  freq add ho jaengi*/
    public static long findSubarray(long[] arr ,int n) 
    {
        HashMap<Integer,Integer> map = new HashMap<>();
       //sum is 0 at idx -1;
       map.put(0,1);
       int sum = 0;
       int count = 0;
       for(int i = 0; i < arr.length; i++){
           sum += arr[i];
           if(map.containsKey(sum) == false){
               map.put(sum,1);
           }
           else{
               count += map.get(sum);
               map.put(sum,map.get(sum)+1);
           }
       }
       return count;
    }

    //another application
   /*agr hme longest subbaraay ki length btani h jisme number of 1 and 0 equal ho, to simple 0 ko -1 se 
   replcae krdo or longest subarray nikal lo jiska sum 0 h, vhi and hoga*/

/* count btana subaarays ka jinka sum "k" k equal ho, simple map m sum vs freq rkhenge
agr sum = y, or map m y-k exist krta h to mtlb bich vale subarray ka sum k h, aise krke count kr lenge*/

   public int subarraySum(int[] nums, int k) {
    HashMap<Integer,Integer> map = new HashMap<>();
    map.put(0,1);
    int sum = 0;
    int count= 0;
    for(int i = 0; i < nums.length; i++){
        sum += nums[i];
        if(map.containsKey(sum-k)){
            count += map.get(sum-k);
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        
    }
    return count;
}
}
