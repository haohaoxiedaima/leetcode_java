package leetcode;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.HashSet;
public class Code {
    public static void main(String[] args) {
        StringBuilder s = new StringBuilder("aaa");
        HashSet<String> set = new HashSet<String>();
        set.add(s.toString());
        System.out.println(s);
        System.out.println(set);
        s.append("ss");
        System.out.println(s);
        System.out.println(set);
    }  
}

