package Graph;

public class FloydWarshall {
/*
    all pair shortest path problem, complexity o(v3) hm hr path m
    that i to j check krte h k ko intermediate leke ki koi better ans h, agr h
    to update ho jata h, now if we analyse last iteration m k== v kth iteration
    yani hr i to j k sari nodes ko intermediate krke best ans dhunda h
    which is equal to all pair shortest path.
*/
    public void shortest_distance(int[][] matrix)
    {   
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == -1){
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        for(int k = 0; k < matrix.length; k++){
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[0].length; j++){
                    if(i == k || j == k ||  i== j || matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == Integer.MAX_VALUE){
                    matrix[i][j] = -1;
                }
            }
        }
        
       
    }
}
