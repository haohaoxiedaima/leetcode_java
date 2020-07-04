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
    public static int longestValidParentheses(String s) {
        Stack<Character> stk = new Stack<Character>();
        int lnum = 0;
        int ans = 0;
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                stk.push(s.charAt(i));
                lnum++;
            }
            else{
                if(lnum > 0){
                    stk.push(s.charAt(i));
                    lnum--;
                }
                else{
                    stk.clear();lnum = 0;
                }
            }
            if(lnum == 0){
                int tmp = stk.size();
                if(ans < tmp) ans = tmp;
            }
        }

        int rnum = 0;
        Stack<Character> stk1 = new Stack<Character>();
        while(!stk.empty()){
            char c = stk.pop();
            if(c == ')'){
                stk1.push(c);
                rnum++;
            }
            else{
                if(rnum > 0){
                    stk1.push(c);
                    rnum--;
                }
                else{
                    stk1.clear();rnum = 0;
                }
            }
            if(rnum == 0){
                int tmp = stk1.size();
                if(ans < tmp) ans = tmp;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String s = "(()";     
        System.out.println(longestValidParentheses(s));
    }  
}



