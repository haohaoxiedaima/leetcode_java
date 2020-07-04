package leetcode;
import java.util.Scanner;
public class Code {
    public static int romanToInt(String s) {
        int[] m = new int[s.length()];
        for(int i = 0;i < s.length();i++){
            if(s.charAt(i) == 'M') m[i] = 1000;
            if(s.charAt(i) == 'D') m[i] = 500;
            if(s.charAt(i) == 'C') m[i] = 100;
            if(s.charAt(i) == 'L') m[i] = 50;
            if(s.charAt(i) == 'X') m[i] = 10;
            if(s.charAt(i) == 'V') m[i] = 5;
            if(s.charAt(i) == 'I') m[i] = 1;
        }
        int i = 0,ans = 0;
        while(i < s.length()){
            if(i == s.length() - 1){
                ans += m[i];i++;
            }
            else if(m[i] < m[i+1]){
                ans += m[i+1];
                ans -= m[i];
                i+=2;
            }
            else{
                ans += m[i];
                i++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        String m = sc.next();
        System.out.println(romanToInt(m));
    }
    
}

