package HashMaps.MaximumConsecutive;

public class MaxConsecutive1 {
    /* longest sequence btani h, 1 ki agr hm atmost k 0 ko flip kr skte h
    to isme hm agr jb tk 1 aara h ans calculate kre or 0 ka count k tk h tb ka ans store
    kre, jese 0  > k ho jaega release krna shuru krde jb tk 0 ka count k tk na phoch jae
    or hr point pe ans check krle*/
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int j = -1;
        // j = -1  mtlb j jisko point krah usko hmne sequence se hta dia
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            //aquire
            if(nums[i] == 0){
                count++;
            }
            //release
            while(count > k){
                j++;
                if(nums[j] == 0){
                    count--;
                }
            }
            int len = i - j;
            ans = Math.max(len,ans);
        }
        return ans;
    }
}
