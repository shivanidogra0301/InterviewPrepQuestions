package Trees;
import java.util.*;
import java.io.*;

public class Queens{

    static class fastReader{
        BufferedReader br;
        StringTokenizer st;

        public fastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        } 

        String Next(){
            while(st == null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }
                catch(IOException e){
                    e.printStackTrace();
                }
            }

            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(Next());
        }

        float nextFloat(){
            return Float.parseFloat(Next());
        }

        boolean nextBoolean(){
            return Boolean.parseBoolean(Next());
        }

        double nextDouble(){
            return Double.parseDouble(Next());
        }

        long nextLong(){
            return Long.parseLong(Next());
        }

        String nextLine(){
            String str = "";
            try{
                str = br.readLine();
            }
            catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }

        String next(){
            return Next();
        }
    }
    static int int_max = Integer.MAX_VALUE;
    static int int_min = Integer.MIN_VALUE;

    private static final fastReader f = new fastReader();
    private static final PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void print(Object o){out.print(o);}
    public static void println(Object o){out.println(o);}
    public static void println(){out.println();}
    
    public static<T extends Comparable<T>> T max(T a , T b){return a.compareTo(b) > 0 ? a : b;}
    public static<T extends Comparable<T>> T min(T a , T b){return a.compareTo(b) > 0 ? b : a;}
    
    /* you are given node and it children and additional values if  child value = 1 and cur node value  = 1
    then you can delete that node count such nodes and sort it . The hint is that you dont have to actually
    delete the node because its presence or absence does not affects its parents ans */
    public static void main(String[] args){
        
        
          solve();
        
        out.close();
    }

    public static void solve(){
      HashMap<Integer,ArrayList<Integer>> tree = new HashMap<>();
      int n = f.nextInt();
      for(int i = 1; i <= n; i++){
          tree.put(i,new ArrayList<>());
      }
      int[] values = new int[n+1];
      for(int i = 1; i <= n; i++){
          int pi = f.nextInt();
          values[i] = f.nextInt();
          if(pi != -1)
            tree.get(pi).add(i);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            if(values[i] == 1){
                boolean flag = true;
                for(Integer ci : tree.get(i)){
                    if(values[ci] != 1){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    ans.add(i);
                }

            }
        }
        Collections.sort(ans);
        StringBuilder sb = new StringBuilder();
        for(int x : ans){
            sb.append(x+" ");
        }
        if(ans.size() == 0){
            System.out.println("-1");
        }else{
            System.out.println(sb);
        }
        
        
    }
}

