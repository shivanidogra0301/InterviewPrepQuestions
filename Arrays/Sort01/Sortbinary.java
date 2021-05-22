package Arrays.Sort01;

public class Sortbinary {
    public static void binSort(int A[], int N)
    {
        int i = 0;
        int j = 0;
        while(i < N){
            if(A[i] == 1){
               
                i++;
            }
            else{
                swap(A,j,i);
                j++;
                i++;
            }
        }
    }
    public static void swap(int[] A,int j, int i){
        int temp = A[j];
        A[j] = A[i];
        A[i] = temp;
    }
}
