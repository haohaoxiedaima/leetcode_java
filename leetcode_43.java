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
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        String ans = "";
        for(int i = 0;i < num2.length();i++){
            ans = ans + "0";
            int tmp = num2.charAt(i) - '0';
            if(tmp == 0) continue;
            String s = new String(num1);
            while(tmp > 1){
                s = string_add(s,num1);
                tmp--;
            }
            ans = string_add(ans,s);
        }
        return ans;
    }
    public static String string_add(String num1,String num2){
        int len1 = num1.length()-1,len2 = num2.length()-1;
        int flag = 0;
        StringBuilder ans = new StringBuilder();
        while(len1 >= 0 || len2 >= 0){
            int t1,t2;
            if(len1 < 0) t1 = 0;
            else t1 = num1.charAt(len1) - '0';
            if(len2 < 0) t2 = 0;
            else t2 = num2.charAt(len2) - '0';
            int tmp = t1 + t2 + flag;
            if(tmp > 9){
                flag = 1;tmp -= 10;
            }
            else flag = 0;
            ans.append((char)(tmp + '0'));
            len1--;len2--;
        }
        if(flag == 1) ans.append('1');
        return ans.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(multiply("2","0"));
    }  
}



