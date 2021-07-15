package HashMaps.Anagrams;
import java.util.*;
public class MinStepsToMakeTwoStringAnagram {
/*
    Given two equal length string, hme minimum replace krna h char ko taki dono anagram bn jae
    loginc agr dono string k hashmap ko dekhe, to agr jis string k char ki freq zyada h, usi string m
    koi aise char honge jinki freq utni hi km hoegi
    for ex aabccee  aabbcce to isme hashmap a2b1c2e2  a2b2c3 to isme 
    clearly dikhra h str1 m e ki freq 2 se zyada h, vhi b+c ki freq 2 se km h
    to ans 2 hoga ki hm 2 char ko replcae kr skte h, 
    to logic ye h zyada vali freq ko count krlo ya km vali, but dono m se ek hi hogi
    hm zyada vali krenge mtlb s2 ko char jo s1 m ni h unko conisder ni krenge
    pr s1 m jo char h, jo s2 m ni h unka count le lenge
*/
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> smap = new HashMap<>();
        char[] sa = s.toCharArray();
        char[] ta = t.toCharArray();
        
        for(int i = 0; i < s.length(); i++){
            smap.put(sa[i],smap.getOrDefault(sa[i],0)+1);
        }
        for(int i = 0; i < t.length();i++){
            char ch = ta[i];
            if(smap.containsKey(ch)){
                if(smap.get(ch) == 1){
                    smap.remove(ch);
                }
                else{
                    smap.put(ch,smap.get(ch)-1);
                }
            }
        }
        int count = 0;
        for(char ch : smap.keySet()){
            count += smap.get(ch);
        }
        return count;
        
    }
}
