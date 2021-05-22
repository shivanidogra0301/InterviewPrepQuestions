package Arrays.Sort01;

public class Sort012 {
    public static void sort012(int a[], int n)
    {
        int i = 0;
        int j = 0;
        int k = a.length-1;
        
        while(i <= k){
            if(a[i] == 1){
                i++;
            }
            else if(a[i] == 0){
                swap(a,i,j);
                j++;
                i++;
            }
            else{
                swap(a,i,k);
                k--;
            }
        }
    }
    public static void swap(int[] a, int x, int y){
        int temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }
}
