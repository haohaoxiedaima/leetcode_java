package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Stack;
public class Code {
    public static int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        if(needle.length() == 0) return 0;
        for(int i = 0;i + needle.length() <= haystack.length();i++){
            if(Objects.equals(needle, haystack.substring(i,i+needle.length())))
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(strStr("hello","ll"));
        sc.close();
    }  
}


