package Arrays;

public class FirstNegativeInWindow {
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {   long[] ans = new long[A.length - K +1];
        long window = 0;
        int widx = -1;
        for(int i = 0; i < K; i++){
            if(A[A.length - i -1] < 0){
                window = A[A.length - i -1];
                widx = A.length - i -1;
            }
        }
        
        ans[ans.length-1] = window;
        int j = ans.length - 2;
        
        for(int i = A.length - 1 - K; i >= 0; i--){
            // System.out.println(i+" "+widx);
            if(A[i] < 0){
                ans[j] = A[i];
                widx = i;
            }
            else if(widx != -1 && widx <= (i+K-1)){
                ans[j] = A[widx];
            }
            else{
                ans[j] = 0;
            }
            j--;
        }
        return ans;
    }
}
