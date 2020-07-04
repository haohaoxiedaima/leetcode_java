package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
public class Code {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(int i = 0;i < s.length();i++){
            char c1 = stk.charAt(i);
            if(c1 == ')' || c1 == ']' || c1 == '}'){
                if(stk.empty()) return false;
                char c2 = stk.pop();
                if(c1 == ')' && c2 == '(') continue;
                if(c1 == ']' && c2 == '[') continue;
                if(c1 == '}' && c2 == '{') continue;
                return false;
            }
            stk.push(c1);
        }
        if(stk.empty()) return true;
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "((()))";
        System.out.println(isValid(s));
        sc.close();
    }  
}


