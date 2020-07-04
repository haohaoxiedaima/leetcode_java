package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
public class Code {
    public static boolean isMatch(String s, String p) {
    	//System.out.println(s.length());
        int[][] flag = new int[s.length()][p.length()];
        return f(s,pre_handle(p),0,0,flag);
    }
    public static boolean f(String s,String p,int spos,int ppos,int[][] flag){
        if(spos >= s.length() && ppos >= p.length()) return true;
        if(s.length() - spos < (p.length() - ppos) / 2) return false;
        if(spos >= s.length()){
            if(p.charAt(ppos) == '*') return f(s,p,spos,ppos+1,flag);
            else return false;
        }
        if(ppos >= p.length()) return false;
        if(flag[spos][ppos] == 1) return true;
        if(flag[spos][ppos] == 2) return false;
        if(p.charAt(ppos) == '?'){
            if(f(s,p,spos+1,ppos+1,flag)) flag[spos][ppos] = 1;
            else flag[spos][ppos] = 2;
            return flag[spos][ppos] == 1;
        }
        if(p.charAt(ppos) != '*'){
            flag[spos][ppos] = 2;
            if(s.charAt(spos) == p.charAt(ppos)){
                if(f(s,p,spos+1,ppos+1,flag)) flag[spos][ppos] = 1;
            }
            return flag[spos][ppos] == 1;
        }
        int k = 0;
        while(spos + k <= s.length()){
            boolean tmp = f(s,p,spos+k,ppos+1,flag);
            k++;
            if(tmp){
                flag[spos][ppos] = 1;
                return true;
            }
        }
        flag[spos][ppos] = 2;
        return false;
    }
    public static String pre_handle(String s){
        if(s.length() <= 1) return s;
        int pos = 0;
        while(pos < s.length() - 1){
            if(s.charAt(pos) == '*' && s.charAt(pos+1) == '*'){
                if(pos + 1 == s.length() - 1) s = s.substring(0,pos+1);
                else s = s.substring(0,pos+1) + s.substring(pos+2,s.length());
            }
            else pos++;
        }
        return s;
    }
    public static void main(String[] args) {
        //System.out.println(pre_handle("**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
        //System.out.println(isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb","**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
        System.out.println(isMatch("a","*"));
    }
}



