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
        HashSet<String> set = new HashSet<String>();
        boolean[] tag = new boolean[words.length];
        for(int i = 0;i < tag.length;i++) tag[i] = true;
        StringBuilder sb = new StringBuilder();
        fuse_words(words,tag,set,sb);

        if(s.length() == 0) return new ArrayList<Integer>();
        if(words.length == 0) return new ArrayList<Integer>();
        List<Integer> ans = new ArrayList<Integer>();

        
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String str = it.next();
            int[] next = new int[str.length()];
            gen_next(next,str);
            List<Integer> tmp = KMP(s,str,next);
            ans.addAll(tmp);
        }
        return ans;        
    }
    public static void fuse_words(String[] words,boolean[] tag,HashSet<String> set,StringBuilder sb){
        int num = 0;
        for(int i = 0;i < tag.length;i++){
            if(tag[i] == true){
                num++;
                sb.append(words[i]);
                tag[i] = false;
                fuse_words(words,tag,set,sb);
                tag[i] = true;
                for(int j = 0;j < words[i].length();j++){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        if(num == 0){
            set.add(sb.toString());
        }
    }

    public static List<Integer> KMP(String s,String word,int[] next){
        int i = 0,j = 0;
        List<Integer> ans = new ArrayList<Integer>();
        while(i < s.length()){
            if(j == -1 || s.charAt(i) == word.charAt(j)){
                i++;j++;
                if(j == word.length()){
                    ans.add(i-j);
                    i = i - word.length() + 1;
                    j = 0;
                }
            }
            else{
                j = next[j];
            }
        }
        return ans;
    }

    public static void gen_next(int[] next,String s){
        next[0] = -1;
        int k = -1,j = 0;
        while(j < s.length() - 1){
            if(k == -1 || s.charAt(k) == s.charAt(j)){
                k++;j++;
                next[j] = k;
            }
            else k = next[k];
        }
    }

    public static void main(String[] args) {
        String[] words = new String[]{"word","good","best","word"};
        String s = "wordgoodgoodgoodbestword";       
        System.out.println(findSubstring(s,words));
    }  

    

}



