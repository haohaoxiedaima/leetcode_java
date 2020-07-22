package Demo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
import java.util.Iterator;

public class LCDemo {
    public static List<String> restoreIpAddresses(String s) {
        ArrayList<String> ans = new ArrayList<String>();
        GetIP(s, 4, new String(), ans);
        return ans;
    }

    /*  s 为剩余字符串
        legalnum 为该IP剩下的未赋值的位数
        递归处理输入的字符串，当字符串处理完时legalnum正好为0则为合法的一个IP
    */
    public static void GetIP(String s, int legalnum, String str, List<String> ans){
        if(s.length() == 0 && legalnum == 0){
            ans.add(str.substring(1));
        }
        else if(legalnum == 0){
            return;
        }
        else{
            for(int i = 0; i < s.length();i++){
                int num = Integer.parseInt(s.substring(0, i+1));
                if(i > 0 && s.charAt(0) == '0') break;
                if(num < 256){
                    GetIP(s.substring(i+1), legalnum - 1, str + "." + String.valueOf(num), ans);
                }
                else break;
            }
        }
    }
    public static void main(String[] args) {
        List<String> ans = restoreIpAddresses("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");
        Iterator iter = ans.iterator();
        while(iter.hasNext()){
            String str = (String)(iter.next());
            System.out.println(str);
        }
    }
}
