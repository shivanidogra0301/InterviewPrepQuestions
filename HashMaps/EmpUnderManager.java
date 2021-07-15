package HashMaps;
import java.io.*;
import java.util.*;

public class EmpUnderManager {
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        HashMap<String,String> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(scn.next(),scn.next());
        }
        scn.close();
        //manager vs employ list is stored visulise this as unidircetion non cycle graph
        HashMap<String,HashSet<String>> tree = new HashMap<>();
        // root of the tree
        String ceo = "";
        for(String emp : map.keySet()){
            String mngr = map.get(emp);
            if(mngr.equals(emp)){
                ceo += mngr;
                continue;
            }
            
            if(tree.containsKey(mngr)){
                HashSet<String> emps = tree.get(mngr);
                emps.add(emp);
                tree.put(mngr,emps);
            }
            else{
                HashSet<String> emps = new HashSet<>();
                emps.add(emp);
                tree.put(mngr,emps);
            }
            
            
        }
        
        HashMap<String,Integer> ans  = new HashMap<>();
        getSize(tree,ceo,ans);
        for(String str : ans.keySet()){
            System.out.println(str+" "+ans.get(str));
        }
        
      }
      
      public static int getSize(HashMap<String,HashSet<String>> tree, String ceo,HashMap<String,Integer> ans ){
          if(!tree.containsKey(ceo)){
              ans.put(ceo,0);
              return 1;
          }
          
          int sum = 0;
          for(String emp : tree.get(ceo)){
              sum += getSize(tree,emp,ans);
          }
          ans.put(ceo,sum);
          return sum+1;
      }
}
