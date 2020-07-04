package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
public class Code {
    static List<String> ans = new ArrayList<String>();
    public static List<String> generateParenthesis(int n) {
        ans.clear();
        if(n == 0) return ans;
        StringBuilder s = new StringBuilder();
        f(s,n,n);
        return ans;

    }

    public static void f(StringBuilder s,int l_num,int r_num){
        if(l_num == 0 && r_num == 0){
            ans.add(s.toString());
        }else{
            if(l_num > 0){
                s.append('(');
                f(s,l_num-1,r_num);
                s.deleteCharAt(s.length() - 1);
            }
            if(r_num > 0 && r_num > l_num){
                s.append(')');
                f(s,l_num,r_num-1);
                s.deleteCharAt(s.length() - 1);
            }
        }
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(generateParenthesis(0));
        sc.close();
    }  
}


