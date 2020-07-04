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
    public static String countAndSay(int n) {
        String ans = "1";
        while(n > 1){
            ans = saybelow(ans);
            n--;
        }
        return ans;
    }
    public static String saybelow(String s){
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            int tmp = 0,pos = i;
            while(i < s.length() && s.charAt(i) == s.charAt(pos)){
                tmp++;
                i++;
            }
            sb.append(Integer.toString(tmp));
            sb.append(s.charAt(pos));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        System.out.println(countAndSay(3));
    }  
}



