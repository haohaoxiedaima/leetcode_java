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
        int words_len = 0;

        for(int i = 0;i < words.length;i++){
            words_len += words[i].length();
        }

        for(int i = 0;i + words_len <= s.length();i++){
            if(set.contains(s.sunstring(i,i+words_len))){
                ans.add(i);
            }
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

    
    

    public static void main(String[] args) {
        String[] words = new String[]{"word","good","best","word"};
        String s = "wordgoodgoodgoodbestword";       
        System.out.println(findSubstring(s,words));
    }  

    

}



