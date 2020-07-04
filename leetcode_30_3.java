package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
public class Code {
    public static List<Integer> findSubstring(String s, String[] words) {
        if(s.length() == 0 || words.length == 0) return new ArrayList<Integer>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0;i < words.length;i++){
            if(!map.containsKey(words[i])) map.put(words[i],1);
            else{
                int tmp = map.get(words[i]);
                map.put(words[i],tmp+1);
            }
        }  
        int wordlen = words[0].length();
        for(int i = 0;i + wordlen * words.length <= s.length();i++){
            if(islegal(map,s,i,wordlen,words.length)){
                ans.add(i);
            }
        }
        return ans;
    }
    public static boolean islegal(HashMap<String,Integer> map,String s,int pos,int wordlen,int wordnum){
        HashMap<String,Integer> m = new HashMap<String,Integer>(map);
        for(int i = 0;i < wordnum;i++){
            String tmp = s.substring(pos + i * wordlen,pos + i * wordlen + wordlen);
            if(!m.containsKey(tmp)) return false;
            int tmpval = m.get(tmp) - 1;
            if(tmpval < 0) return false;
            m.put(tmp,tmpval);
        }
        return true;
    }
    public static void main(String[] args) {
        String[] words = new String[]{"word","good","best","word"};
        String s = "wordgoodgoodgoodbestword";       
        System.out.println(findSubstring(s,words));
    }  
}



