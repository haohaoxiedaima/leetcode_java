package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
public class Code {
    public static List<String> letterCombinations(String digits) {
        //String[] s = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ans = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        f(sb,digits,ans);
        return ans;
    }

    public static void f(StringBuilder sb,String digits,List<String> ans) {
        if(digits.length() == 0) ans.add(sb.toString());
        else{
            String tmp = getchars(digits.toString().charAt(0));
            for(int i = 0;i < tmp.length();i++){
                sb.append(tmp.charAt(i));
                f(sb,digits.substring(1,digits.length()),ans);
                sb.deleteCharAt(sb.length()-1);
            }
        }

    }
    public static String getchars(char c){
        String[] s = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return s[c-'2'];
    }




    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(letterCombinations("23456"));
        sc.close();
    }  
}

