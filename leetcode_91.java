package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
public class Code {
    public static int numDecodings(String s) {
        return f(s,0);       
    }
    public static int f(String s, int pos){
        if(pos >= s.length()) return 1;
        if(s.charAt(pos) == '0') return 0;
        if(s.charAt(pos) <= '2' && pos + 1 < s.length() && s.charAt(pos + 1) == '0'){
            return f(s,pos+2);
        }
        if((s.charAt(pos) == '2' && pos + 1 < s.length() && s.charAt(pos + 1) <= '6') || (s.charAt(pos) == '1' && pos + 1 < s.length())){
            return f(s,pos+1) + f(s,pos+2);
        }
        return f(s,pos+1);
    }
    public static void main(String[] args) {       
        System.out.println(numDecodings("12"));
    } 
}



