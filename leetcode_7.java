package leetcode;
import java.util.Scanner;
public class Code {
    public static int reverse(int x) {
        String s = String.valueOf(x);
        if(x < 0){s = s.substring(1,s.length());}
        StringBuilder sb = new StringBuilder(s);
        String rev_s = sb.reverse().toString();
        String max = String.valueOf(Integer.MAX_VALUE);
        String min = String.valueOf(Integer.MIN_VALUE);
        min = min.substring(1,min.length());
        if(x > 0 && compare_str(rev_s,max) > 0) return 0;
        if(x < 0 && compare_str(rev_s,min) > 0) return 0;
        int res = Integer.parseInt(rev_s);
        if(x < 0) res = res * (-1);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        System.out.println(reverse(n));
    }
    public static int compare_str(String s,String p){
        if(s.length() < p.length()){return -1;}
        else if(s.length() > p.length()){return 1;}
        return s.compareTo(p);
    }
}

