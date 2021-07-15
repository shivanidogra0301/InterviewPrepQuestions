package Graph;
import java.util.*;
class SlidingPuzzle{
    public int slidingPuzzle(int[][] board) {
        int[][] dirs = {{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        Queue<StringBuilder> q = new LinkedList<>();      
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                sb.append(board[i][j]);
            }
        }
        q.add(sb);
        HashSet<String> set = new HashSet<>();
        set.add(sb.toString());
        int count = 0;
        while(q.size()> 0){
            int size = q.size();
            while(size-- > 0){
                StringBuilder rem = q.remove();
            
            
            if(rem.toString().equals("123450")){
                return count;
            }
            
            int idx = -1;
            for(int i = 0; i < 6; i++){
                char ch = rem.charAt(i);
                if(ch == '0'){
                    idx = i;
                    break;
                }
            }
            // System.out.println(idx);
            int [] dir = dirs[idx];
            for(int i = 0; i < dir.length; i++){
                StringBuilder ns = new StringBuilder(rem);
                char temp = ns.charAt(idx);
                ns.setCharAt(idx, ns.charAt(dir[i]));
                ns.setCharAt(dir[i],temp);
                if(!set.contains(ns.toString())){
                    q.add(ns);
                    set.add(ns.toString());
                }
                // System.out.println(ns.toString());
            }
            }
            
            count++;
            
        } 
        return -1;
    }
    
}